package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonLazy {
    //Eager Initialization
    private static AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    //Construtor privado pq vc tem que pegar a instancia pelo getInstance
    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
    //Thread safe
    public  static AircraftSingletonLazy getINSTANCE() {
        if(INSTANCE == null){
            synchronized (AircraftSingletonLazy.class){
                if(INSTANCE == null){
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }
}
