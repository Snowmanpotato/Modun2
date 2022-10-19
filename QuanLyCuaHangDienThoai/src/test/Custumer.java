import java.util.Objects;

public class Custumer {
    private int idCustumer;
    private String nameCustumer;
    private String phoneNumber;
    private String email;
    private String gender;
    private int age;

    public Custumer(int id, String name, String phone, String email, String gender, int age) {
        this.idCustumer = id;
        this.nameCustumer = name;
        this.phoneNumber = phone;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Custumer(int id, String name) {
        this.idCustumer = id;
        this.nameCustumer = name;
    }

    public Custumer(){}

    public int getIdCustumer() {
        return idCustumer;
    }

    public void setIdCustumer(int idCustumer) {
        this.idCustumer = idCustumer;
    }

    public String getNameCustumer() {
        return nameCustumer;
    }

    public void setNameCustumer(String nameCustumer) {
        this.nameCustumer = nameCustumer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Custumer{" +
                "idCustumer=" + idCustumer +
                ", nameCustumer='" + nameCustumer + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Custumer custumer = (Custumer) o;
        return idCustumer == custumer.idCustumer && age == custumer.age && Objects.equals(nameCustumer, custumer.nameCustumer) && Objects.equals(phoneNumber, custumer.phoneNumber) && Objects.equals(email, custumer.email) && Objects.equals(gender, custumer.gender);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(idCustumer, nameCustumer, phoneNumber, email, gender, age);
//    }
    @Override
    public int hashCode() {
        return Objects.hash(idCustumer);
    }
}
