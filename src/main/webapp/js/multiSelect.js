$(document).ready( function () {

    $('#headingOne').on('click',function(event){
        $("#btnUserFilter").click();
    });
    $("#formUserView").submit(function(event) {
        event.preventDefault();
        const table = $('#DTUserView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTUserView',
                "dataSrc": "",
                "data": function (d) {
                    d.idUser = $('#idUser').val();
                    d.login = $('#login').val();
                    d.registrationDate = $('#registrationDate').val();
                    d.statusName = $('#statusName').val();
                    d.nameRole = $('#nameRole').val();
                }
            },
            "columns": [
                {"data": "idUser"},
                {"data": "login"},
                {"data": "registrationDate"},
                {"data": "statusName"},
                {"data": "nameRole"}
            ]
        });
        $('#DTApart tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            $("#apartment").val(data.idApartment.toString());
            $("#ownerApartment").val(data.apartmentOwner.toString());

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
    ////////////////////////////////
    $('#headingTwo').on('click', function(e){
        alert('Обработчик для кнопки: '+$(this).text());
        /*const table = $('#DTUserView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTUserView',
                "dataSrc": "",
                "data": function (d) {
                    d.idUser = $('#idUser').val();
                    d.login = $('#login').val();
                    d.registrationDate = $('#registrationDate').val();
                    d.statusName = $('#statusName').val();
                    d.nameRole = $('#nameRole').val();
                }
            },
            "columns": [
                {"data": "idUser"},
                {"data": "login"},
                {"data": "registrationDate"},
                {"data": "statusName"},
                {"data": "nameRole"}
            ]
        });
        $('#DTApart tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            $("#apartment").val(data.idApartment.toString());
            $("#ownerApartment").val(data.apartmentOwner.toString());

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });*/
    });
});