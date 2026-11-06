package model;

public class User {
    private final long id;
    private final Name name;
    private final Credentials credentials;

    public User(long id, Name name, Credentials credentials) {
        this.id = id;
        this.name = name;
        this.credentials = credentials;
    }

    public long getId() { return this.id; }
    public Name getName() { return this.name; }
    public Credentials getCredentials() { return this.credentials; }
}
