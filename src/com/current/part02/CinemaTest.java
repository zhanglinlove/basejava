package com.current.part02;

public class CinemaTest {

	public static void main(String[] args) {
		Cinema c = new Cinema();
		
		TicketOffice1 ticket1 = new TicketOffice1(c);
		Thread t1 = new Thread(ticket1, "ticketOffice1");
		
		TicketOffice2 ticket2 = new TicketOffice2(c);
		Thread t2 = new Thread(ticket2, "ticketOffice2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("room1 vacancies:" + c.getVacanciesCinema1());
		System.out.println("room2 vacancies:" + c.getVacanciesCinema2());
	}
}
