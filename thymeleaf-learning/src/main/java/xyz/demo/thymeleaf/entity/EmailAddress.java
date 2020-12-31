package xyz.demo.thymeleaf.entity;

public final class EmailAddress {

    private String name, domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return String.format("%s@%s", this.name, this.domain);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof EmailAddress)) return false;
        if(this == obj) return true;

        EmailAddress emailAddress = (EmailAddress) obj;
        return emailAddress.getName().equals(this.getName())
            && emailAddress.getDomain().equals(this.getDomain());
    }
}
