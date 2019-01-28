package app.models;

import app.annotations.password.Password;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private byte[] profilePicture;
    private LocalDateTime registrationDate;
    private LocalDateTime lastTimeLoggedIn;
    private int age;
    private Boolean isDeleted;
    private Town bornTown;
    private Town liveTown;
    private List<User> usersFriends;
    private List<User> friendsToUser;

    public User() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="username", nullable=false, unique = true)
    @Size(min = 6, max = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.length()<6 || username.length()>30){
            throw new IllegalArgumentException("Invalid Username!");
        }
        this.username = username;
    }

    @Column(nullable = false)
    @Password(containsDigit = true,
    containsLowerCase = true,
    containsUpperCase = true,
    containsSpecialSymbol = true,
    minLength = 5,
    maxLength = 25)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
/*        if(password.length()<6 || password.length()>50 ||
                (!isContainingLowerCase(password)|| !isContainingUpperCase(password)
                        ||!isContainingDigit(password)||!isContainingSpecialSymbol(password))){
                throw new IllegalArgumentException("Invalid password!");
        }*/
        this.password = password;
    }

    @Column(name="email", nullable = false)
    @Email(regexp = "^([A-Za-z\\d]+[\\.\\-\\_]*[A-Za-z\\d]+)@([\\w\\d\\.\\_\\-]+(\\.)+[\\w\\d]+)$",
    message = "Invalid email!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
/*        String emailRegex = "^([A-Za-z\\d]+[\\.\\-\\_]*[A-Za-z\\d]+)@([\\w\\d\\.\\_\\-]+(\\.)+[\\w\\d]+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if(!email.matches(emailRegex)){
            throw new IllegalArgumentException("Invalid email!");
        }*/
        this.email = email;
    }

    @Column(name="profile_picture", columnDefinition = "blob")
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Column(name="registration_date")
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name="last_time_logged_in", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Basic
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<1||age>120){
            throw new IllegalArgumentException("Invalid age value!");
        }
        this.age = age;
    }

    @Column(name="is_deleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    @JoinColumn(name="born_town_id", referencedColumnName = "id")
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    @JoinColumn(name="live_town_id", referencedColumnName = "id")
    public Town getLiveTown() {
        return liveTown;
    }

    public void setLiveTown(Town liveTown) {
        this.liveTown = liveTown;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = this.firstName+ " "+this.lastName;
    }
    @ManyToMany
    @JoinTable(name="users_friends",
    joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="friend_id", referencedColumnName = "id"))
    public List<User> getUsersFriends() {
        return usersFriends;
    }


    public void setUsersFriends(List<User> usersFriends) {
        this.usersFriends = usersFriends;
    }

    @ManyToMany(mappedBy = "usersFriends")
    public List<User> getFriendsToUser() {
        return friendsToUser;
    }

    public void setFriendsToUser(List<User> friendsToUser) {
        this.friendsToUser = friendsToUser;
    }

}
