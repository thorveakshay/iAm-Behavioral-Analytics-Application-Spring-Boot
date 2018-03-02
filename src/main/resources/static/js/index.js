Survey
    .StylesManager
    .applyTheme("default");

var json = {
    pages: [
        {
            title: "Skin/theme choices in your WinForms applications",
            questions: [
                {
                    type: "radiogroup",
                    name: "skinNumber",
                    title: "How many skin/theme choices do you currently offer within your WinForms applications?",
                    isRequired: true,
                    choices: ["many|More than one"],
                    hasOther: true,
                    otherText: "One (please specify its name)",
                    otherErrorText: "Please enter a name of the skin/theme you use in your applications."
                }
            ]
        }, {
            title: "Do you ship all DevExpress skins with your applications?",
            questions: [
                {
                    type: "radiogroup",
                    name: "skinShips",
                    title: "If you include more than one skin/theme within your application, please specify whether you ship all DevExpress WinForms skins/themes or whether you ship a select number.",
                    isRequired: true,
                    choices: [
                        "all|I ship all skins", "selected|I ship only a select number"
                    ],
                    visibleIf: "{skinNumber} = 'many'"
                }
            ]
        }, {
            title: "Skin/Theme Value for End-Users",
            questions: [
                {
                    type: "matrix",
                    name: "skinValue",
                    title: " If you ship all DevExpress skins/themes, please rank the importance and/or business value of the skins below to your end-users.",
                    visibleIf: "{skinNumber} = 'many' and {skinShips} = 'all'",
                    columns: [
                        "high|High value for end-users", "donotknow|I don't know", "low|Low value for end-users"
                    ],
                    rows: [
                        "msOffice latest|Skins Emulating the Latest Versions of MS Office and Windows",
                        "msOffice previous|Skins Emulating Previous Versions of MS Office and Windows",
                        "macOS|Skins Emulating Mac OS",
                        "vs.net|Skins Emulating Visual Studio",
                        "adobe|Skins Emulating Well-Known Apps Like Adobe Lightroom",
                        "holiday|Holiday / Seasonal Themes",
                        "unique|Other Unique Themes",
                        "devExpress|Other Unique Themes Designed by DevExpress"
                    ]
                }
            ]
        }, {
            title: "Skins/Themes You Include in Your Application",
            questions: [
                {
                    type: "checkbox",
                    name: "skinSelected",
                    title: "If you ship only a select number of DevExpress skins/themes, please specify the skins/themes you include in your application.",
                    visibleIf: "{skinNumber} = 'many' and {skinShips} != 'all'",
                    choices: [
                        "msOffice latest|Skins Emulating the Latest Versions of MS Office and Windows",
                        "msOffice previous|Skins Emulating Previous Versions of MS Office and Windows",
                        "macOS|Skins Emulating Mac OS",
                        "vs.net|Skins Emulating Visual Studio",
                        "adobe|Skins Emulating Well-Known Apps Like Adobe Lightroom",
                        "holiday|Holiday / Seasonal Themes",
                        "unique|Other Unique Themes",
                        "devExpress|Other Unique Themes Designed by DevExpress"
                    ]
                }
            ]
        }, {
            title: "Personal Favorite",
            questions: [
                {
                    type: "text",
                    name: "skinFavorite",
                    title: "Do you have a personal favorite skin/theme?",
                    visibleIf: "{skinNumber} = 'many'"
                }
            ]
        }, {
            title: "Color Variety versus Shape & Style Variety",
            questions: [
                {
                    type: "radiogroup",
                    name: "userImportance",
                    title: "What is more important for your end-users?",
                    visibleIf: "{skinNumber} = 'many'",
                    choices: ["color|Color variety", "elements|Elements, shapes and styles"]
                }
            ]
        }, {
            title: "Do you modify skins?",
            questions: [
                {
                    type: "radiogroup",
                    name: "skinModify",
                    title: "Do you modify DevExpress WinForms skins/themes used within your application to address specific business requirements?",
                    choices: ["Yes", "No"]
                }
            ]
        }, {
            title: "Reasons to Modify Skins",
            questions: [
                {
                    type: "comment",
                    name: "skinModifyReason",
                    title: "If you modify DevExpress skins/themes before shipping your application, please briefly explain the reasons for doing so (such as specific branding requirements)."
                }
            ]
        }
    ]
};

window.survey = new Survey.Model(json);

survey
    .onComplete
    .add(function (result) {
        
        $.ajax({
            type: "POST",
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
		            url : "/json/survey.htm",
            data: JSON.stringify(result.data), // Note it is important
            success :function() {
             // do what ever you want with data
            	document
                .querySelector('#surveyResult')
                .innerHTML = "result: " + JSON.stringify(result.data);
           }
        });
    });

$("#surveyElement").Survey({model: survey});
