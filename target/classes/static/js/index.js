Survey
    .StylesManager
    .applyTheme("default");

var json = {
    locale: "en",
    title: {
        default: "Basic Behavioral and communication style analyser",
        en: "Basic Behavioral and communication style analyzer"
    },
    pages: [
        {
            name: "Introduction",
            elements: [
                {
                    type: "html",
                    name: "Basic Behavioral and communication style analyser",
                    html: "<p>\nThis is an informal survey, designed to determine how you usually act in everyday\nrelated situations. The idea is to get a clear description of how you see yourself.\nOn the next pages, select A or B in each pair of statements, which shows\nthe one that MOST, describes you.\n<br>\nSurvey taken from The Platinum Rule by Tony Alessandra, Ph.D, & Michael J. O’Connor Ph.D. New York, New York, Warner Brooks 1996\n\n</p>"
                }
            ],
            title: "Introduction"
        },
        {
            name: "Page 1",
            elements: [
                {
                    type: "radiogroup",
                    name: "question1",
                    title: "question1",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I’m usually open to getting to know people personally and establishing relationships with them."
                        },
                        {
                            value: "2",
                            text: "I’m not usually open to getting to know people personally and establishing relationships with them."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question2",
                    title: "question2",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually react slowly and deliberately."
                        },
                        {
                            value: "2",
                            text: "I usually react quickly and spontaneously."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question3",
                    title: "question3",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I’m usually guarded about other people’s use of my time."
                        },
                        {
                            value: "2",
                            text: "I’m usually open to other people’s use of my time."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question4",
                    title: "question4",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually introduce myself at social gatherings."
                        },
                        {
                            value: "2",
                            text: "I usually wait for others to introduce themselves to me at social gatherings."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question5",
                    title: "question5",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually focus my conversations on the interests of the people involved, even if that means straying from the business or subject at hand."
                        },
                        {
                            value: "2",
                            text: "I usually focus my conversations on the tasks, issues, business, or subject at hand."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question6",
                    title: "question6",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I’m usually not assertive, and I can be patient with a slow pace."
                        },
                        {
                            value: "2",
                            text: "I’m usually assertive, and at times I can be impatient with a slow pace."
                        }
                    ]
                }
            ],
            title: "Page 1"
        },
        {
            name: "Page 2",
            elements: [
                {
                    type: "radiogroup",
                    name: "question7",
                    title: "question7",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually make decisions based on facts or evidence."
                        },
                        {
                            value: "2",
                            text: "I usually make decisions based on feelings , experiences or relationships."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question8",
                    title: "question8",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually contribute frequently to group conversations."
                        },
                        {
                            value: "2",
                            text: "I usually contribute infrequently to group conversations."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question9",
                    title: "question9",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually prefer to work with and through others, providing support when possible."
                        },
                        {
                            value: "2",
                            text: "I usually prefer to work independently or dictate the conditions in terms of how others are involved."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question10",
                    title: "question10",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually ask questions or speak tentatively and indirectly."
                        },
                        {
                            value: "2",
                            text: "I usually make empathic statements or directly expressed opinions."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question11",
                    title: "question11",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually focus primarily on ideas, concepts, or results."
                        },
                        {
                            value: "2",
                            text: "I usually focus primarily on persons, interactions, and feelings."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question12",
                    title: "question12",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually use gestures, facial expression, and voice intonations to emphasize points."
                        },
                        {
                            value: "2",
                            text: "I usually do not use gestures, facial expressions, and voice intonations to emphasize points"
                        }
                    ]
                }
            ],
            title: "Page 2"
        },
        {
            name: "page 3",
            elements: [
                {
                    type: "radiogroup",
                    name: "question13",
                    title: "question13",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually accept others’ points of view (ideas, feelings, and concerns)."
                        },
                        {
                            value: "2",
                            text: "I usually don’t accept others’ points of view (ideas, feelings, and concerns)"
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question14",
                    title: "question14",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually respond to risk and change in a cautious or predictable manner."
                        },
                        {
                            value: "2",
                            text: "I usually respond to risk and change in dynamic or unpredictable manner."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question15",
                    title: "question15",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually prefer to keep personal feelings and thoughts private, sharing only when I wish to do to."
                        },
                        {
                            value: "2",
                            text: "I usually find it natural and easy to share and discuss my feelings with others."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question16",
                    title: "question16",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually seek out new or different experiences and situations."
                        },
                        {
                            value: "2",
                            text: "I usually choose known or similar situations and relationships."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question17",
                    title: "question17",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I’m usually responsive to others’ agendas, interests, and concerns."
                        },
                        {
                            value: "2",
                            text: "I’m usually directed toward my own agendas, interests and concerns."
                        }
                    ]
                },
                {
                    type: "radiogroup",
                    name: "question18",
                    title: "question18",
                    isRequired: true,
                    choices: [
                        {
                            value: "1",
                            text: "I usually respond to conflict slowly and indirectly."
                        },
                        {
                            value: "2",
                            text: "I usually respond to conflict quickly and directly."
                        }
                    ]
                }
            ],
            title: "page 3"
        }
    ],
    sendResultOnPageNext: true,
    showProgressBar: "top",
    firstPageIsStarted: true
};

window.survey = new Survey.Model(json);

survey
    .onComplete
    .add(function (result) {

        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: "result",
            data: JSON.stringify(result.data), // it is important
            success: function () {
                // do what ever you want with data
                alert("Hello! I am an alert box!!");

                document

                    .querySelector('#surveyResult')
                    .innerHTML = "result: " + JSON.stringify(result.data);
            }
        });
    });

$("#surveyElement").Survey({model: survey});
