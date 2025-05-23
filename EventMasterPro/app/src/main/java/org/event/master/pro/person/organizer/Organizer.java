package org.event.master.pro.person.organizer;

//import static org.event.master.pro.model.util.Data.events;

import org.event.master.pro.person.account.Account;



public class Organizer extends Account{
    private boolean status;

    public Organizer(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol) {
        super(documentType, documenNumbert, name, mail, phone, password, rol);
        this.status = true;
    }

    @Override
    public boolean isStatus() {
        return status;
    }
    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
    /*public void createEvent(List<Location> loc){
        printMessage("Create New Event");
        int typeOption = intInput("""
                Select event type: 
                1.Festival
                2.Concert
                3.Conference""");
        switch (typeOption){
            case 1:
                Festival festival = new Festival();
                festival = festival.createEvent(loc);
                createEntries(festival);
                events.add(festival);
                break;
            case 2:
                Concert concert = new Concert();
                concert = concert.createEvent(loc);
                createEntries(concert);
                events.add(concert);
                break;
            case 3:
                Conference conference = new Conference();
                conference = conference.createEvent(loc);
                createEntries(conference);
                events.add(conference);
                break;
            default:
                printMessage("Invalid event type selected.");
                break;
        }
    }
    public void editEvent(List<Event> events,List<Location> locations){
        boolean eventFound = false;
        String nameToUpdate = strigsInput("Enter the name of the event to update: ");
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName().equalsIgnoreCase(nameToUpdate)) {
                Data.events.set(i,events.get(i).updateEvent(locations));
                eventFound=true;
                break;
            }
        }
        if (!eventFound) {
            printMessage("Event not found");
        }
    }
    public void cancelEvent(List<Event> events){
        boolean eventFound = false;
        String nameToUpdate = strigsInput("Enter the name of the event to update: ");
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName().equalsIgnoreCase(nameToUpdate)) {
                Data.events.set(i,events.get(i).changeStatusEvent(events.get(i)));
            }
        }
        if (!eventFound) {
            printMessage("Event not found");
        }
    }
    public void consultFinances(){}
    public void seeTicketsAvailability(){}
    public void viewEventSummary(List<Event> events){
        Event event = searchEvent(events);
        if (event != null){
            printMessage(String.format("""
                ----- Event -----
                Event Name: %s
                Description: %s
                Date: %s
                Location: %s
                Participants: %s
                Status: %s
                """, event.getName(), event.getDescription(), event.getDateEvent(), event.getLocation(), event.getParticipantsNumbers(), event.getStatusEvent()));
        }
    }

    public void listEvent(List<Event> events){
        printMessage("----- List of events -----");
        for(Event event :events){
            event.consultEvent(event);
        }
    }
    public void createEntries(Event event){
        Ticket ticket = new Ticket();
        int count = 0;
        int countParticipantsNumbers = event.getParticipantsNumbers();
        while (countParticipantsNumbers>0) {
            printMessage("----- Create Ticket -----");
            String zone = strigsInput("Enter the zone to be created: ");
            double price = doubleInput("Enter the price of this zone: ");
            do {
                count = intInput("Enter the quantity of tickets: ");
                if (count > countParticipantsNumbers) {
                    printMessage("The quantity exceeds the number of participants remaining (" + countParticipantsNumbers + "). Please try again.");
                } else if (count <= 0) {
                    printMessage("You must enter a quantity greater than 0.");
                }
            } while (count > countParticipantsNumbers || count <= 0);
            event.setTickets(ticket.createEntry(event, zone, count, price));
            countParticipantsNumbers -= count;
        }
    }
*/
}
