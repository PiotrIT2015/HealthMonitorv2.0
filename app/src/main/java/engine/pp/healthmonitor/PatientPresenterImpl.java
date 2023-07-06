package engine.pp.healthmonitor;

public class PatientPresenterImpl implements PatientView{

    String firstName;
    String lastName;
    int pesel;

    public PatientPresenterImpl(String firstName, String lastName, int pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;

    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the pesel
     */
    public int getPesel() {
        return pesel;
    }
    /**
     * @param pesel the pesel to set
     */
    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName  + ", pesel="
                + pesel + "]";
    }

}
