import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
public class HotelRoomBookingSystem {    
      public static void main(String[] args) {        
                     HotelManager hotel = new HotelManager();        
                     hotel.addRoom(new StandardRoom(101));        
                     hotel.addRoom(new StandardRoom(102));        
                     hotel.addRoom(new DeluxeRoom(201));        
                     hotel.addRoom(new SuiteRoom(301));       
                     System.out.println("===== Hotel Room Booking System =====");     
                     hotel.showAvailableRooms();      
                     Customer c1 = new Customer(1, "Arun Kumar");        
                     Customer c2 = new Customer(2, "Priya Sharma");        
                     System.out.println("\n--- Booking Rooms ---");        
                     Booking b1 = hotel.bookRoom(c1, 201, 3);       
                     Booking b2 = hotel.bookRoom(c2, 301, 2);        
                     hotel.bookRoom(c2, 201, 1);        
                     System.out.println("\n--- Booking Details ---");       
                     hotel.displayBooking(b1.getBookingId());        
                     System.out.println();        
                     hotel.displayBooking(b2.getBookingId());       
                     System.out.println("\n--- Cancelling Booking " + b2.getBookingId() + " ---");        
                     hotel.cancelBooking(b2.getBookingId());       
                     hotel.displayBooking(b2.getBookingId());        
                     System.out.println();       
                     hotel.showAvailableRooms();    
} 
} 
abstract class Room {    
        private int roomNumber;    
        private boolean booked;    
        Room(int roomNumber) {        
                   this.roomNumber = roomNumber;        
                   this.booked = false;    
             }   
             int getRoomNumber() { return roomNumber; }
             boolean isBooked() { return booked; }    
             void setBooked(boolean booked) { this.booked = booked; }    
             abstract String getType();    
             abstract double getRatePerNight(); 
             } 
             class StandardRoom extends Room {    
                   StandardRoom(int no) { super(no); }   
                   String getType() { return "Standard"; }   
                   double getRatePerNight() { return 2000.0; } 
             } 
             class DeluxeRoom extends Room {
                DeluxeRoom(int no) { super(no); }   
                String getType() { return "Deluxe"; }    
                double getRatePerNight() { return 3500.0; } 
             } 
             class SuiteRoom extends Room {    
                 SuiteRoom(int no) { super(no); }    
                 String getType() { return "Suite"; }    
                 double getRatePerNight() { return 6000.0; } 
             } 
            class Customer {    
                  private int id;    
                  private String name;    
                  Customer(int id, String name) {       
                        this.id = id;       
                        this.name = name;    
                   }    
            int getId() { return id; }   
            String getName() { return name; }
            } 
            class Booking {    
               private int bookingId;    
               private Customer customer;    
               private Room room;    
               private int nights;    
               private String status;    
               Booking(int bookingId, 
               Customer customer, Room room, int nights) {        
                      this.bookingId = bookingId;        
                      this.customer = customer;        
                      this.room = room;        
                      this.nights = nights;        
                      this.status = "Confirmed;
               }
               int getBookingId() 
               { 
                    return bookingId; 
                    }    
               Customer getCustomer() { return customer; }    
               Room getRoom() { return room; }    
               int getNights() { return nights; }   
               String getStatus() { return status; }    
               void setStatus(String status) { this.status = status; }   
               double getCharge() { return nights * room.getRatePerNight(); } 
               } 
               class HotelManager {    
                        private List<Room> rooms = new ArrayList<>();    
                        private Map<Integer, Booking> bookings = new HashMap<>();    
                        private int nextBookingId = 1001;    
                        void addRoom(Room room) { rooms.add(room); }    
                        void showAvailableRooms() {        
                               System.out.println("Available Rooms:");        
                               for (Room r : rooms) {            
                                          if (!r.isBooked())            {                
                                                      System.out.printf("  Room %d | %-8s | Rs. %.2f per night%n",                       
                                                       r.getRoomNumber(), r.getType(), r.getRatePerNight());
                        }
                }
}
Booking bookRoom(Customer customer, int roomNumber, int nights) {        
                    for (Room r : rooms) {            
                            if (r.getRoomNumber() == roomNumber) {               
                                  if (r.isBooked()) {                   
                                         System.out.println("Room " + roomNumber + " is already booked.");        
                                        return null;                
                      }               
                      r.setBooked(true);                
                      Booking b = new Booking(nextBookingId++, customer, r, nights);                bookings.put(b.getBookingId(), b);                
                      return b;            
                       }        
                   }        
                   System.out.println("Room " + roomNumber + " not found.");        
                   return null;    
                   }    
                   void cancelBooking(int bookingId) {        
                        Booking b = bookings.get(bookingId);
                        if (b == null) {            
                                 System.out.println("Booking " + bookingId + " not found.");            
                                 return;       
                                 }       
                                 b.setStatus("Cancelled");        
                                 b.getRoom().setBooked(false);   
                        }    
                        void displayBooking(int bookingId) {        
                                     Booking b = bookings.get(bookingId);        
                                     if (b == null) {            
                                           System.out.println("Booking " + bookingId + " not found.");          
                                           return;       
                                     }        
                                     System.out.println("Booking ID : " + b.getBookingId());      
                                     System.out.println("Customer   : " + b.getCustomer().getName());     
                                     System.out.println("Room       : " + b.getRoom().getRoomNumber()              
                                                    + " (" + b.getRoom().getType() + ")");               
                                     System.out.println("Duration   : " + b.getNights() + " night(s)");   
                                     System.out.printf("Charge     : Rs. %.2f%n", b.getCharge());        
                                     System.out.println("Status     : " + b.getStatus());
                                     }
               }

 




