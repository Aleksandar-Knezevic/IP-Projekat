package net.etfbl.ip.ipspringbackend.models;

public class MailResponseModel {
    private String email;
    private String body;

    public MailResponseModel() {
    }

    public MailResponseModel(String email, String body) {
        this.email = email;
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "MailResponseModel{" +
                "email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public void setBody(String body) {
        this.body = body;
    }

}
