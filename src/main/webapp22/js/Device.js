$(document).ready( function () {
/////Автозагрузка при открытии аккордеона
    $('#headingOne').one('click',function(event){
        //////////////////////
        const table = $('#DTFunctionDeviceView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTFunctionDeviceView',
                "dataSrc": "",
                "data": function (d) {
                    d.idDevice = $('#idDevice').val();
                }
            },
            "columns": [
                {"data": "idFunction"},
                {"data": "nameFunction"},
                {"data": "nameType"}
            ]
        });
        $('#DTFunctionDeviceView tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            document.location = './viewFunc?idFunction=' + data.idFunction;
        });
    });
    ////////////////////////////////
});