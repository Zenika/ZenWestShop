'use strict';

/* Controllers */


function HomeCtrl() {}
HomeCtrl.$inject = [];

function CvsCtrl($rootScope, $scope, Cv, $location) {
    $scope.consultants = Cv.query();

    $scope.goTo = function(consultant) {
        console.info("consultant : "+consultant._links.self.href)
        $rootScope.link = consultant._links.self.href;
        $location.path("/consultants/"+consultant.resourceId);
    }
};

function CvCtrl($scope, $routeParams, Cv) {
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

    $scope.cv = Cv.get({cvId:$routeParams.consultantId});

    $scope.consultants = Cv.query();

    $scope.updateCv = function() {
        if (this.wine.id > 0)
            this.wine.$update({wineId:this.wine.id});
        else
            this.wine.$save();
        window.location = "#/wines";



    };



//    function WineListCtrl(Wine) {
//
//        this.wines = Wine.query();
//
//    }

//    function WineDetailCtrl(Wine) {
//
//        this.wine = Wine.get({wineId:this.params.wineId});
//
//
//        this.saveWine = function () {
//            if (this.wine.id > 0)
//                this.wine.$update({wineId:this.wine.id});
//            else
//                this.wine.$save();
//            window.location = "#/wines";
//        }
//
//        this.deleteWine = function () {
//            this.wine.$delete({wineId:this.wine.id}, function() {
//                alert('Wine ' + wine.name + ' deleted')
//                window.location = "#/wines";
//            });
//        }
//
//    }

}
CvCtrl.$inject = ['$scope'];
