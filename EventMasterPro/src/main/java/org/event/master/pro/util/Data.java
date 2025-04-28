package org.event.master.pro.util;

import org.event.master.pro.event.*;
import org.event.master.pro.person.Admin;
import org.event.master.pro.person.Customer;
import org.event.master.pro.person.Organizer;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Data {
    public static Organizer organizer = new Organizer(
            "Cédula de Ciudadanía",
            "1012345678",
            "Carlos Gómez",
            "carlos.gomez@mail.com",
            "3112345678",
            "password123",
            "organizer"
    );
    public static Customer customer = new Customer(
            "Cédula de ciudadanía",
            "1012345678",
            "Carlos Pérez",
            "carlos.perez@ejemplo.com",
            "300-1234567",
            "customerPass123",
            "customer",
            28
    );
    public static Admin admin = new Admin(
            "Cédula de Ciudadanía",
            "1012345678",
            "Ana Martínez",
            "ana.martinez@mail.com",
            "3112345678",
            "password123",
            "admin"
    );

    public static List<Location> locations = new ArrayList<>(List.of(
            new Location(
                    "Movistar Arena",
                    "Cra. 30 # 63-53, Bogotá",
                    15000,
                    true,
                    12000000,
                    "Bogotá"
            ),
            new Location(
                    "Centro de Convenciones Plaza Mayor",
                    "Cl. 41 #55-80, Medellín",
                    5000,
                    true,
                    6000000,
                    "Medellín"
            ),
            new Location(
                    "Centro de Eventos Valle del Pacífico",
                    "Yumbo, Kilómetro 1. Vía Cali - Yumbo",
                    8000,
                    true,
                    7000000,
                    "Cali"
            ),
            new Location(
                    "Estadio Metropolitano Roberto Meléndez",
                    "Calle 47 con Vía 40, Barranquilla",
                    46000,
                    false,
                    20000000,
                    "Barranquilla"
            ),
            new Location(
                    "Teatro Jorge Eliécer Gaitán",
                    "Carrera 7 #22-47, Bogotá",
                    1700,
                    true,
                    2000000,
                    "Bogotá"
            )
    ));
    public static List<Event> events = new ArrayList<>(List.of(
            new Conference(
                    "Andrés Oppenheimer",
                    "El futuro del trabajo en América Latina",
                    1,
                    "Futuro Laboral 2025",
                    "Tendencias laborales y automatización en América Latina",
                    new Date(2025 - 1900, 5, 12),
                    new Time(20, 0, 0),
                    "Created",
                    locations.get(0),
                    2,
                    "Universidad de los Andes",
                    "All Ages",
                    800
            ),
            new Concert(
                    "Festival Joropo",
                    "Música llanera y folclor colombiano",
                    new Date(2025 - 1900, 5, 12),
                    new Time(20, 0, 0),
                    "Created",
                    locations.get(1),
                    4,
                    "Alcaldía de Villavicencio",
                    "All Ages",
                    12000,
                    "Reynaldo Armas",
                    "Cholo Valderrama",
                    "Folclor Llanero"
            ),
            new Festival(
                    Set.of("Tarima Principal", "Tarima Alternativa"),
                    2,
                    2,
                    "Festival Estéreo Picnic",
                    "Música alternativa y pop internacional",
                    new Date(2025 - 1900, 5, 12),
                    new Time(20, 0, 0),
                    "Created",
                    locations.get(2),
                    8,
                    "Páramo Presenta",
                    "+18",
                    30000
            )
    ));
}
