/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.finance;

import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.event.master.pro.enums.EventStatus;
import org.event.master.pro.event.Event.Event;
import org.event.master.pro.event.Event.EventDAO;
import static org.event.master.pro.util.ShowPanelUtil.showEditEventPanel;
import static org.event.master.pro.util.ShowPanelUtil.showListEventPanel;
import static org.event.master.pro.util.ShowPanelUtil.showSeeEventPanel;
import org.event.master.pro.view.countermanagement.CreateFinancePanel;
import org.event.master.pro.view.customermanagement.BuyTicketPanel;

/**
 *
 * @author Luisa
 */
public class FinanceUI {

    public static void buttonFunctional(JFrame container, MouseEvent evt, JTable eventTable, FinanceDAO fdao) throws SQLException {
        double finance;
        EventDAO dao = new EventDAO();
        int row = eventTable.rowAtPoint(evt.getPoint());
        int column = eventTable.columnAtPoint(evt.getPoint());
        String type = eventTable.getValueAt(row, 7).toString();
        int idEvent = Integer.parseInt(eventTable.getValueAt(row, 8).toString());
        String nameEvent = eventTable.getValueAt(row, 0).toString();
        if (column == eventTable.getColumnModel().getColumnIndex("Edit")) {
            showEditEventPanel(container, idEvent);
        } else if (column == eventTable.getColumnModel().getColumnIndex("Publish")) {
            int row2 = eventTable.getSelectedRow();
            if (row2 >= 0) {
                int eventId = (int) eventTable.getValueAt(row2, eventTable.getColumnModel().getColumnIndex("ID"));
                String currentStatus = (String) eventTable.getValueAt(row2, eventTable.getColumnModel().getColumnIndex("Status"));

                if ("PUBLISHED".equalsIgnoreCase(currentStatus)) {
                    JOptionPane.showMessageDialog(null, "The event is already published.");
                } else {
                    
                    dao.updateEventStatus(eventId, EventStatus.Published);
                    JOptionPane.showMessageDialog(null, "Event published successfully.");
                    showListEventPanel(container);
                }
            }
        } else if (column == eventTable.getColumnModel().getColumnIndex("See")) {
            showSeeEventPanel(container, idEvent, type);
        } else if (column == eventTable.getColumnModel().getColumnIndex("Finance")) {
            String eventStatus = eventTable.getValueAt(row, 2).toString();
            if (!eventStatus.equalsIgnoreCase("Created")) {
                JOptionPane.showMessageDialog(null, "You can only assign finance to events in 'Created' status.");
                return;
            }

            CreateFinancePanel iap = new CreateFinancePanel();
            int option = JOptionPane.showConfirmDialog(
                    null,
                    iap,
                    "Finance linked!",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (option == JOptionPane.OK_OPTION) {
                finance = iap.saveFinance();
                if (finance != -1) {
                    int existing = fdao.countFinanceAssigned(idEvent);
                    if (existing > 0) {
                        int confirm = JOptionPane.showConfirmDialog(
                                null,
                                "This event already has finance assigned. Do you want to update it?",
                                "Confirm Update",
                                JOptionPane.YES_NO_OPTION
                        );
                        if (confirm == JOptionPane.YES_OPTION) {
                            fdao.updateFinance(idEvent, finance);
                            JOptionPane.showMessageDialog(null, "Finance updated successfully for event: " + nameEvent);
                        }
                    } else {
                        fdao.saveFinance(idEvent, finance);
                        JOptionPane.showMessageDialog(null, "Finance assigned successfully for event: " + nameEvent);
                    }
                }
            }
        } else if (column == eventTable.getColumnModel().getColumnIndex("Buy Ticket")) {
            Event event = dao.consultEventById(idEvent);
            if (!event.getStatusEvent().equalsIgnoreCase("Published")) {
                JOptionPane.showMessageDialog(null, "Only published events allow ticket purchases.");
                return;
            }
            BuyTicketPanel buyTicketPanel = new BuyTicketPanel(idEvent);
            JOptionPane.showMessageDialog(null, buyTicketPanel, "Buy Tickets", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
