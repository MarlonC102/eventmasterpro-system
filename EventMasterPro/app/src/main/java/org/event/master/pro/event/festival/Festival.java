
package org.event.master.pro.event.festival;

import org.event.master.pro.event.Event.Event;
import org.event.master.pro.event.Event.IEvent;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.ticket.Ticket;

import static org.event.master.pro.util.Util.*;

public class Festival extends Event{
    private Set<String> stage = new HashSet<>();
    int numberOfStage;
    private int day;
    private List<Ticket> ticket;

    public Festival() {

    }

    /*public Festival(Set<String> stage, int numberOfStage, int day, String name, String description, LocalDateTime dateTimeEvent, String statusEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, List<Ticket> ticket) {
        super(name, description, dateTimeEvent, statusEvent, location, duration, sponsor, classification, participantsNumbers);
        this.stage = stage;
        this.day = day;
        this.numberOfStage = numberOfStage;
        this.ticket = ticket;
    }
*/
    public Set<String> getStage() {
        return stage;
    }

    public void setStage(Set<String> stage) {
        this.stage = stage;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getNumberOfStage() {
        return numberOfStage;
    }

    public void setNumberOfStage(int numberOfStage) {
        this.numberOfStage = numberOfStage;
    }

    public Festival createEvent(List<Location> loc) {
        Festival festival = new Festival();
        festival.setName(strigsInput("Enter festival name: "));
        festival.setDescription(strigsInput("Enter description: "));
        festival.setStatusEvent("Created");
        //festival.setLocation(selectLocation(loc));
        festival.setDuration(intInput("Enter event duration (hours): "));
        festival.setSponsor(strigsInput("Enter main sponsor: "));
        festival.setClassification(strigsInput("Enter classification: "));
        //festival.setParticipantsNumbers(valideQuorum(festival.getLocation()));
        festival.setDay(intInput("Enter the number of days the festival lasts: "));
        numberOfStage = intInput("Enter number of stages: ");
        festival.setNumberOfStage(numberOfStage);
        festival.setStage(festival.setStages(numberOfStage));
        //festival.setDateEvent(inputDate("Enter event date (yyyy-MM-dd): "));
        //festival.setTimeEvent(inputTime("Enter event time (HH:mm): "));
        Ticket.setMaxTickets(festival.getParticipantsNumbers());
        printMessage("Festival created!");
        return festival;
    }

    public Festival updateEvent(List<Location> locations) {
        printMessage("Concert found. Enter new values:");
        this.setDescription(strigsInput("Enter new description: "));
        //this.setDateEvent(inputDate("Enter new date (yyyy-MM-dd): "));
        //this.setTimeEvent(inputTime("Enter new time (HH:mm): "));
        //this.setLocation(selectLocation(locations));
        this.setDuration(intInput("Enter new duration (hours): "));
        this.setSponsor(strigsInput("Enter new sponsor: "));
        this.setClassification(strigsInput("Enter new classification: "));
        //this.setParticipantsNumbers(valideQuorum(this.getLocation()));
        this.setDay(intInput("Enter the number of days the festival lasts: "));
        numberOfStage = intInput("Enter number of stages: ");
        this.setNumberOfStage(numberOfStage);
        this.setStage(this.setStages(numberOfStage));
        this.setDay(intInput("Enter the days"));
        Ticket.setMaxTickets(this.getParticipantsNumbers());
        printMessage("Festival updated successfully!");
        return this;
    }

    public void consultEvent(Event festival) {
        if (festival != null) {
            printMessage(String.format("""
                ----- Festival -----
                Event Name: %s
                Date: %s
                """,festival.getName()));
        } else {
            printMessage("No festivals to show.");
        }
    }

    public Event consultSpecificEvent(List<Event> concerts) {
        String data = strigsInput("Enter the name of concert");
        if (concerts != null) {
            for (Event concert : concerts) {
                if (concert.getName().toLowerCase().equals(data.toLowerCase())) {
                    printMessage(concert.toString());
                    return concert;
                }
            }
        } else {
            return null;
        }
        return null;
    }

     /*@Override
   public Location selectLocation(List<Location> locations) {
        String locationEvent = null;
        do {
            locationEvent = strigsInput("Enter the name of the location to select it: ");
            if (Location.consultSpecificLocation(locationEvent, locations) != null) {
                return Location.consultSpecificLocation(locationEvent, locations);
            } else {
                printMessage("Location not found. Please try again.");
            }
        } while (true);
    }*/

    public Set<String> setStages(int numberOfStages) {
        Set<String> selectedStages = new HashSet<>();
        int i = 0;
        while (i < numberOfStages) {
            printMessage("""
                    -------------Select stages-------------
                    1. Food Court (Area with food trucks, restaurants, and snack bars.)
                    2. Recreational Zone (Space for games, sports, relaxation activities, inflatables.)
                    3. Merchandising Zone (Official stores for t-shirts, posters, souvenirs.)
                    4. VIP Zone (Exclusive area for VIP pass holders.)
                    --------------------------------------------""");

            int op = intInput("Select an option");
            switch (op) {
                case 1 -> {
                    selectedStages.add("Food Court (Area with food trucks, restaurants, and snack bars.)");
                    i++;
                }
                case 2 -> {
                    selectedStages.add("Recreational Zone (Space for games, sports, relaxation activities, inflatables.)");
                    i++;
                }
                case 3 -> {
                    selectedStages.add("Merchandising Zone (Official stores for t-shirts, posters, souvenirs.)");
                    i++;
                }
                case 4 -> {
                    selectedStages.add("VIP Zone (Exclusive area for VIP pass holders.)");
                    i++;
                }
                default -> {
                    printMessage("Invalid option. Try again.");
                }
            }
        }
        return selectedStages;
    }

    public void createEvent(List<Event> events, List<Object> specificEvents) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
 
}

