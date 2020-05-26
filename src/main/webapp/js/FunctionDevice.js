$(document).ready( function (){
   // Highcharts.getJSON('https://www.highcharts.com/samples/data/aapl-c.json', function (data) {
        $.post('/deviceFuncData',{'idFunction':$("#idFunction").val()},function(data) {
            data = jQuery.parseJSON(data);
        // Create the chart
        Highcharts.stockChart('container', {


            rangeSelector: {
                selected: 1
            },
            series: [{
                name: 'Data',
                data: data,
                type: 'areaspline',
                threshold: null,
                tooltip: {
                    valueDecimals: 2
                },
                fillColor: {
                    linearGradient: {
                        x1: 0,
                        y1: 0,
                        x2: 0,
                        y2: 1
                    },
                    stops: [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                    ]
                }
            }]
        });
    });
    $("#range_02").ionRangeSlider({
        min: $("#minData").val(),
        max: $("#maxData").val(),
        from: $("#data").val(),
        onFinish: function (data) {
            $("#data").prop("value", data.from);
        }
    });
});