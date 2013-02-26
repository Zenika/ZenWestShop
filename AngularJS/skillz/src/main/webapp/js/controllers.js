'use strict';

/* Controllers */


function HomeCtrl() {}
HomeCtrl.$inject = [];

CvsCtrl.$inject = ['$rootScope', '$scope', 'Cv', '$location', '$routeParams'];
function CvsCtrl($rootScope, $scope, Cv, $location, $routeParams) {
    $scope.consultants = Cv.query();

    $scope.goTo = function(consultant) {
        console.info("consultant : "+consultant._links.self.href)
        $rootScope.link = consultant._links.self.href;
        $location.path("/consultant/"+consultant.resourceId);
    }

    $scope.deleteConsultant = function(index, consultant) {
        Cv.delete({cvId:consultant.resourceId}, new function () {
            $scope.consultants.splice(index, 1);
        });
    };

    if ($routeParams.page == null) {
        $scope.currentPage = 0;
    } else {
        $scope.currentPage = +$routeParams.page; //convert to int
    }

    if ($scope.currentPage < 0) {
        $scope.currentPage = 0;
    }

    $scope.numberOfPages = 5;

    $scope.prevPage = function() {
        if ($scope.currentPage > 0) {
            $scope.currentPage--;
            console.info("--");
            $location.path('/consultants').search('page='+$scope.currentPage);
        }
    }

    $scope.nextPage = function() {
        if ($scope.currentPage < $scope.numberOfPages) {
            $scope.currentPage++;
            console.info("++");
            $location.path('/consultants').search('page='+$scope.currentPage);
        }
    }

    $scope.setPage = function() {
        $scope.currentPage = this.n;
        console.info("setPage : "+$scope.currentPage);
        $location.path('/consultants').search('page='+$scope.currentPage);
    }

    $scope.range = function (start, end) {
        var ret = [];
        if (!end) {
            end = start;
            start = 0;
        }
        for (var i = start; i < end; i++) {
            ret.push(i);
        }
        return ret;
    };



};

CvCtrl.$inject = ['$scope', '$routeParams', 'Cv', '$location'];
function CvCtrl($scope, $routeParams, Cv, $location) {
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

    $scope.cv = Cv.get({cvId:$routeParams.id});

    $scope.updateCv = function() {
        if (this.cv.resourceId > 0)
            this.cv.$update({cvId:this.cv.resourceId});
        else
            this.cv.$save();

        $location.path('/consultant/'+this.cv.resourceId);
    };


    if (!$scope.cv) {
        cv.firstName = 'Prénom';
        cv.lastName = 'Nom';
    }
}

newCvCtrl.$inject = ['$scope', 'Cv', '$location'];
function newCvCtrl($scope, Cv, $location) {
    $scope.updateCv = function(cv) {
        Cv.save(cv);
        $location.path('/consultants');
    };

    if ($scope.cv == null) {
        $scope.cv = {
            lastName: "Nom",
            firstName: "Prénom",
            title: "Titre",
            subTitle: "Sous-titre",
            exp: "6",
            mail: "raphael.delaporte@zenika.com",
            blog: "http://bpelsoa.blogspot.com"
        }
    }

}

FileUploadCtrl.$inject = ['$scope']
function FileUploadCtrl($scope) {
    $scope.setFiles = function(element) {
        $scope.$apply(function($scope) {
            console.log('files:', element.files);
            // Turn the FileList object into an Array
            $scope.files = []
            for (var i = 0; i < element.files.length; i++) {
                $scope.files.push(element.files[i])
            }
            $scope.progressVisible = false
        });
    };

    $scope.uploadFile = function() {
        var fd = new FormData()
        for (var i in $scope.files) {
            console.log($scope.files[i].name)
            fd.append("file", $scope.files[i])
        }
        var xhr = new XMLHttpRequest()
        xhr.upload.addEventListener("progress", uploadProgress, false)
        xhr.addEventListener("load", uploadComplete, false)
        xhr.addEventListener("error", uploadFailed, false)
        xhr.addEventListener("abort", uploadCanceled, false)
        xhr.open("POST", "services/fileupload")
        $scope.progressVisible = true
        xhr.send(fd)
    }

    function uploadProgress(evt) {
        scope.$apply(function(){
            if (evt.lengthComputable) {
                scope.progress = Math.round(evt.loaded * 100 / evt.total)
            } else {
                scope.progress = 'unable to compute'
            }
        })
    }

    function uploadComplete(evt) {
        /* This event is raised when the server send back a response */
        console.log(evt.target.responseText);
    }

    function uploadFailed(evt) {
        console.error("There was an error attempting to upload the file");
    }

    function uploadCanceled(evt) {
        $scope.$apply(function(){
            $scope.progressVisible = false
        })
        console.warn("The upload has been canceled by the user or the browser dropped the connection");
    }
}



