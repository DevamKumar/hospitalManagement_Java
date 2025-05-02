import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class HospitalManagementSystem {
    private JFrame frame;
    private JPanel panel;
    private JTextField nameField, ageField, contactField, doctorNameField, specialtyField, doctorContactField, dateField, timeField;
    private JButton registerPatientButton, registerDoctorButton, scheduleAppointmentButton;
    private JTable patientTable, doctorTable, appointmentTable;
    private DefaultTableModel patientTableModel, doctorTableModel, appointmentTableModel;
    private JComboBox<String> patientComboBox, doctorComboBox;

    private String dbUrl = "jdbc:mysql://localhost:3306/hospital_management_system";
    private String dbUsername = "root";
    private String dbPassword = "";

    public HospitalManagementSystem() {
        frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Patient", createPatientPanel());
        tabs.addTab("Doctor", createDoctorPanel());
        tabs.addTab("Appointment", createAppointmentPanel());

        panel.add(tabs, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);

        // Populate combo boxes initially
        refreshComboBoxes();
    }

    private JPanel createPatientPanel() {
        JPanel patientPanel = new JPanel();
        patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.Y_AXIS));

        JPanel form = new JPanel(new GridLayout(4, 2));
        form.add(new JLabel("Name:"));
        nameField = new JTextField();
        form.add(nameField);
        form.add(new JLabel("Age:"));
        ageField = new JTextField();
        form.add(ageField);
        form.add(new JLabel("Contact:"));
        contactField = new JTextField();
        form.add(contactField);

        registerPatientButton = new JButton("Register Patient");
        registerPatientButton.addActionListener(new RegisterPatientListener());

        patientPanel.add(form);
        patientPanel.add(registerPatientButton);

        patientTableModel = new DefaultTableModel(new String[]{"Name", "Age", "Contact"}, 0);
        patientTable = new JTable(patientTableModel);
        patientPanel.add(new JScrollPane(patientTable));

        return patientPanel;
    }

    private JPanel createDoctorPanel() {
        JPanel doctorPanel = new JPanel();
        doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.Y_AXIS));

        JPanel form = new JPanel(new GridLayout(4, 2));
        form.add(new JLabel("Name:"));
        doctorNameField = new JTextField();
        form.add(doctorNameField);
        form.add(new JLabel("Specialty:"));
        specialtyField = new JTextField();
        form.add(specialtyField);
        form.add(new JLabel("Contact:"));
        doctorContactField = new JTextField();
        form.add(doctorContactField);

        registerDoctorButton = new JButton("Register Doctor");
        registerDoctorButton.addActionListener(new RegisterDoctorListener());

        doctorPanel.add(form);
        doctorPanel.add(registerDoctorButton);

        doctorTableModel = new DefaultTableModel(new String[]{"Name", "Specialty", "Contact"}, 0);
        doctorTable = new JTable(doctorTableModel);
        doctorPanel.add(new JScrollPane(doctorTable));

        return doctorPanel;
    }

    private JPanel createAppointmentPanel() {
        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setLayout(new BoxLayout(appointmentPanel, BoxLayout.Y_AXIS));

        JPanel form = new JPanel(new GridLayout(5, 2));
        form.add(new JLabel("Patient:"));
        patientComboBox = new JComboBox<>();
        form.add(patientComboBox);
        form.add(new JLabel("Doctor:"));
        doctorComboBox = new JComboBox<>();
        form.add(doctorComboBox);
        form.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        form.add(dateField);
        form.add(new JLabel("Time (HH:MM):"));
        timeField = new JTextField();
        form.add(timeField);

        scheduleAppointmentButton = new JButton("Schedule Appointment");
        scheduleAppointmentButton.addActionListener(new ScheduleAppointmentListener());

        appointmentPanel.add(form);
        appointmentPanel.add(scheduleAppointmentButton);

        appointmentTableModel = new DefaultTableModel(new String[]{"Patient", "Doctor", "Date", "Time"}, 0);
        appointmentTable = new JTable(appointmentTableModel);
        appointmentPanel.add(new JScrollPane(appointmentTable));

        return appointmentPanel;
    }

    private void refreshComboBoxes() {
        patientComboBox.removeAllItems();
        doctorComboBox.removeAllItems();
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement stmt = conn.createStatement()) {

            ResultSet rsPatients = stmt.executeQuery("SELECT name FROM patients");
            while (rsPatients.next()) {
                patientComboBox.addItem(rsPatients.getString("name"));
            }

            ResultSet rsDoctors = stmt.executeQuery("SELECT name FROM doctors");
            while (rsDoctors.next()) {
                doctorComboBox.addItem(rsDoctors.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error refreshing combo boxes: " + ex.getMessage());
        }
    }

    private class RegisterPatientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String age = ageField.getText();
            String contact = contactField.getText();
            try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                 PreparedStatement ps = conn.prepareStatement("INSERT INTO patients (name, age, contact) VALUES (?, ?, ?)")) {
                ps.setString(1, name);
                ps.setInt(2, Integer.parseInt(age));
                ps.setString(3, contact);
                ps.executeUpdate();
                patientTableModel.addRow(new Object[]{name, age, contact});
                refreshComboBoxes();
            } catch (SQLException ex) {
                System.out.println("Error registering patient: " + ex.getMessage());
            }
        }
    }

    private class RegisterDoctorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = doctorNameField.getText();
            String specialty = specialtyField.getText();
            String contact = doctorContactField.getText();
            try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                 PreparedStatement ps = conn.prepareStatement("INSERT INTO doctors (name, specialty, contact) VALUES (?, ?, ?)")) {
                ps.setString(1, name);
                ps.setString(2, specialty);
                ps.setString(3, contact);
                ps.executeUpdate();
                doctorTableModel.addRow(new Object[]{name, specialty, contact});
                refreshComboBoxes();
            } catch (SQLException ex) {
                System.out.println("Error registering doctor: " + ex.getMessage());
            }
        }
    }

    private class ScheduleAppointmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String patient = (String) patientComboBox.getSelectedItem();
            String doctor = (String) doctorComboBox.getSelectedItem();
            String date = dateField.getText();
            String time = timeField.getText();
            try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                 PreparedStatement ps = conn.prepareStatement("INSERT INTO appointments (patient, doctor, date, time) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, patient);
                ps.setString(2, doctor);
                ps.setString(3, date);
                ps.setString(4, time);
                ps.executeUpdate();
                appointmentTableModel.addRow(new Object[]{patient, doctor, date, time});
            } catch (SQLException ex) {
                System.out.println("Error scheduling appointment: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HospitalManagementSystem::new);
    }
}
