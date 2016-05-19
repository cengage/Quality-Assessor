var controllers = {};

controllers.mainCtl = function($scope) {
    $scope.platforms =  [
        {
            id: "1",
            title: "OMNI",
            totalProducts: 4,
            products: [
                {
                    title: "Literature Resources from Gale"
                },
                {
                    title: "GTX"
                },
                {
                    title: "ITX"
                },
                {
                    title: "Gale Virtual Reference Library"
                }
            ]
        },
        {
            id: "2",
            title: "Pangea",
            totalProducts: 4,
            products: [
                {
                    title: "Science in Context"
                },
                {
                    title: "History in Context"
                },
                {
                    title: "Associated Press"
                },
                {
                    title: "National Geographic"
                }
            ]
        },
        {
            id: "3",
            title: "Ocean",
            totalProducts: 1,
            products: [
                {
                    title: "Ocean WebApp"
                }
            ]
        },
        {
            id: "4",
            title: "BI",
            totalProducts: 2,
            products: [
                {
                    title: "Business Insights: Global"
                },
                {
                    title: "Business Insights: Marketing"
                }
            ]
        }
    ]


}

app.controller(controllers);