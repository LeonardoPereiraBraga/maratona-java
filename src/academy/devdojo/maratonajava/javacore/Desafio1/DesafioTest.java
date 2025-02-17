package academy.devdojo.maratonajava.javacore.Desafio1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DesafioTest {
    public static void main(String[] args) throws IOException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        File filediretorio = new File("usuarios");
        File file = new File("formulario.txt");
        List<String> linhasFormulario = new ArrayList<>();
        // Passo 1: Ler todas as linhas do arquivo e armazenar em uma lista
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhasFormulario.add(linha);
            }
        }
        int tamanhoFormulario = linhasFormulario.size();
        File[] arquivos = filediretorio.listFiles();
        int qtdeUsuarios = arquivos.length;
        Scanner sc = new Scanner(System.in);
        menuPrincipal();
        int resposta = sc.nextInt();

        switch (resposta){
            case 1:
                cadastrarUsuario(qtdeUsuarios, filediretorio, file, usuarios);
                cadastrarUsuario(qtdeUsuarios, filediretorio, file, usuarios);
                break;
            case 2:
                listarUsuarios(filediretorio);
                break;
            case 3:
                cadastrarPergunta(tamanhoFormulario);
                break;
            case 4:
                deletarPergunta(filediretorio);
                break;
            case 5:
                pesquisarUser(usuarios);
                break;
        }


    }

    public static void cadastrarUsuario(int qtdeUsuarios, File filediretorio, File file, ArrayList<Usuario> usuarios){

        filediretorio.mkdir();

        File fileUnnamed = new File(filediretorio,"semNome.txt");
        Scanner sc = new Scanner(System.in);
        try(FileWriter fw = new FileWriter(file, true);
            FileWriter fwUsuario = new FileWriter(fileUnnamed, true);
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedWriter bwUsuario = new BufferedWriter(fwUsuario);
            FileReader fr = new FileReader(file);
            FileReader frUsuario = new FileReader(fileUnnamed);
            BufferedReader br = new BufferedReader(fr);
            BufferedReader brUsuario = new BufferedReader(frUsuario);

        )
        {
            fileUnnamed.createNewFile();
            String linha;
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }
            String nome = sc.nextLine();
            if(nome.length() < 10) throw new IllegalArgumentException("Nome deve ter mais 10 Caracteres");
            String email = sc.nextLine();
            boolean emailAlreadyExists = verifyEmail(email, usuarios);
            if(emailAlreadyExists) throw new IllegalArgumentException("Esse email já existe");
            if(!email.contains("@")) throw new IllegalArgumentException("Deve ter @ no email");
            int idade = sc.nextInt();
            if(idade < 18) throw new IllegalArgumentException("Minimo 18 anos");
            double altura = sc.nextDouble();
            if(!(altura + "").contains(",") && !(altura + "").contains(".")) throw new IllegalArgumentException("Altura deve ter virgulas");
            String qtdUsuarioString = String.valueOf(qtdeUsuarios + 1);
            Usuario usuario = new Usuario(nome,email,idade,altura);
            usuarios.add(usuario);
            File fileUsuario = new File(filediretorio,qtdUsuarioString + "-" + nome.toUpperCase().replaceAll("\\s", "")+".txt");
            bwUsuario.write(nome);
            bwUsuario.newLine();
            bwUsuario.write(email);
            bwUsuario.newLine();
            bwUsuario.write(idade + "");
            bwUsuario.newLine();
            bwUsuario.write(altura + "");
            bwUsuario.newLine();
            bwUsuario.flush();
            fw.close();
            fwUsuario.close();
            bw.close();
            bwUsuario.close();
            fr.close();
            frUsuario.close();
            br.close();
            brUsuario.close();
            fileUnnamed.renameTo(fileUsuario);


        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void listarUsuarios(File diretorio) throws IOException {
        ArrayList<String> nomesUsuarios = new ArrayList<>();
        File[] arquivos = diretorio.listFiles();
        for (File arquivo : arquivos) {

            File tempArchive = new File(diretorio,arquivo.getName());
            FileReader fr = new FileReader(tempArchive);
            BufferedReader br = new BufferedReader(fr);
            nomesUsuarios.add(br.readLine());

        }
        int index = 1;
        for (String nomesUsuario : nomesUsuarios) {
            System.out.println(index + " - " + nomesUsuario);
            index++;
        }
    }

    public static void menuPrincipal(){
        System.out.println("1 - Cadastrar o usuário\n" +
                "2 - Listar todos usuários cadastrados\n" +
                "3 - Cadastrar nova pergunta no formulário\n" +
                "4 - Deletar pergunta do formulário\n" +
                "5 - Pesquisar usuário por nome ou idade ou email\n");
    }

    public static boolean verifyEmail(String email, ArrayList<Usuario> usuarios ){
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }


    public static void cadastrarPergunta(int tamanhoFormulario) throws IOException {
        Scanner sc = new Scanner(System.in);
        File file = new File("formulario.txt");
        System.out.println(file.getName());
        FileWriter fw = new FileWriter(file, true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            System.out.println("Escreva sua pergunta: ");
            String newQuestion = sc.nextLine();
            bw.newLine();
            bw.write((tamanhoFormulario + 1) + " - " + newQuestion);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deletarPergunta(File diretorio) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha a pergunta a ser deletada: ");
        int deleted = sc.nextInt();
        File file = new File("formulario.txt");
        List<String> linhas = new ArrayList<>();

        // Passo 1: Ler todas as linhas do arquivo e armazenar em uma lista
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        }

        if (linhas.size() < 5){
            System.out.println("Nao pode apagar 4 questoes");
            return;
        }

        // Passo 2: Remover a última linha
        if (!linhas.isEmpty()) {
            linhas.remove(deleted - 1);
        }

        // Passo 3: Reescrever o arquivo com as linhas restantes
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            for (String lin : linhas) {
                bw.write(lin);
                bw.newLine();
            }
            bw.flush(); // Garante que os dados sejam gravados no arquivo
        }

        System.out.println("Última linha removida com sucesso!");
    }

    public static void pesquisarUser(ArrayList<Usuario> usuarios){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o termo para pesquisar: ");
        String nome = sc.nextLine();
        for (Usuario usuario : usuarios) {
            String regex = ".*\\b\\w*" + nome + "\\w*\\b.*";
            String texto = usuario.getNome();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(texto);
            while(matcher.find()){
                if(matcher.group() == usuario.getNome() ||
                        matcher.group() == usuario.getEmail() ||
                        matcher.group() == (usuario.getIdade() + "")
                ){
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Idade: " + usuario.getIdade());
                    System.out.println("Altura: " + usuario.getAltura());

                }
                System.out.println(matcher.start() + " " + matcher.group() + "\n");
            }
        }
        System.out.println("Pesquisado");
    }



}
