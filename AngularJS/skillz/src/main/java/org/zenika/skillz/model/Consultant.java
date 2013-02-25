package org.zenika.skillz.model;

import java.io.Serializable;
import java.util.Set;

public class Consultant implements Serializable {

    /**
     * name: "Raphaël Delaporte",
     title1: "Consultant Java/ JEE / SOA / Messaging",
     title2: "Directeur Technique Zenika Ouest",
     exp: "6 ans d'expérience",
     mail: "raphael.delaporte@zenika.com",
     blog: "http://bpelsoa.blogspot.com",
     {
     title: "Formateur",
     desc: ["SOA - BPEL - AMQP - JMS - ESB - Java - Web Services - RabbitMQ"]
     }
     ],
     competences: [
     {
     title: "Java",
     desc: "Java - Java EE - Spring Framework - Java ME - CLDC - AOP"
     },
     {
     title: "Tuning",
     desc: "VisualGC - Jconsole - JVMStat - Samurai - Yourkit Java Profiler - Jprofiler"
     },
     {
     title: "Persistance",
     desc: "Hibernate - JPA - MyBatis - JDBC"
     },
     {
     title: "SOA / Intégration",
     desc: "BPEL (Oracle SOA Suite / Apache ODE) - EIP (Apache Camel / Spring Integration) - ESB (ServiceMix, Mule) - Web Services (WS-* / REST - Apache CXF / Jersey) - XML/XSLT - jBPM"
     }
     ]
     */


    public static final transient Consultant NO_CONSULTANT = new Consultant();
    private Long id;
    private String lastName;
    private String firstName;
    private String mail;
    private String title;
    private String subTitle;
    private Integer experienceLength;
    private Set<Competence> competences;

    private Profil profil;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }
}
