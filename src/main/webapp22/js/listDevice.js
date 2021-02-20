$(document).ready( function () {

    $("#formDevicesView").submit(function(event){
        event.preventDefault();
        const table = $('#DTDeviceView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTDeviceView',
                "dataSrc": "",
                "data": function (d) {
                    d.idDevice = $('#idDevice').val();
                    d.nameDevice = $('#nameDevice').val();
                    d.nameController = $('#nameController').val();
                    d.nameType = $('#nameType').val();
                    d.nameStatus = $('#nameStatus').val();
                }
            },
            "columns": [
                {"data": "idDevice"},
                {"data": "nameDevice"},
                {"data": "nameController"},
                {"data": "nameType"},
                {"data": "nameStatus"}
            ]
        });
        $('#DTDeviceView tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            document.location = './viewDevice?idDevice=' + data.idDevice;
        });
    });
    $("#btnDeviceViewFilter").click();
});