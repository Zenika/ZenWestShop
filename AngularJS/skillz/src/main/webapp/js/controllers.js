'use strict';

/* Controllers */


function HomeCtrl() {}
HomeCtrl.$inject = [];

function CvCtrl($scope) {
    $scope.cv =
    {
        name: "Raphaël Delaporte",
        title1: "Consultant Java/ JEE / SOA / Messaging",
        title2: "Directeur Technique Zenika Ouest",
        exp: "6 ans d'expérience",
        mail: "raphael.delaporte@zenika.com",
        blog: "http://bpelsoa.blogspot.com",
        profil: [
            {
                title: "Consultant",
                desc: [
                    "Expertise SOA sur des projets télécoms en contexte offshore (Inde)",
                    "Expertise prototypage de solution de messaging (AMQP / JMS)",
                    "Expertise Java embarqué - Exécution de JVM sur microcontrôleurs STM]"
                ]
            },
            {
                title: "Architecte",
                desc: [
                    "Architecte logiciel sur le projet de refonte du SI SFR (SOA, JavaEE)",
                    "Architecte JavaEE et SOA dans un contexte offshore (Inde)"
                ]
            },
            {
                title: "Conférencier",
                desc: [
                    "SOA - Petits déjeuners Zenika Rennes & Nantes - octobre 2012",
                    "Apache Camel - JUG Rennes & Nantes - novembre 2011 & mai 2012",
                    "Spring Integration - Société Générale Nantes - décembre 2011",
                    "AMQP - What’s Next Replay Rennes & Nantes - novembre 2011"
                ]
            },
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
    }
}
CvCtrl.$inject = ['$scope'];
