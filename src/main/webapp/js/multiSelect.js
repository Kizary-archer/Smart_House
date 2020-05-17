$(document).ready( function () {
    $("#formApart").submit(function(event) {
        event.preventDefault();

        const table = $('#DTApart').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTApart',
                "dataSrc": "",
                "data": function (d) {
                    d.idApartment = $('#idApartment').val();
                    d.numberApartment = $('#numberApartment').val();
                    d.countRoom = $('#countRoom').val();
                    d.livingSpace = $('#livingSpace').val();
                    d.meterPrice = $('#meterPrice').val();
                }
            },
            "columns": [
                {"data": "idApartment"},
                {"data": "numberApartment"},
                {"data": "countRoom"},
                {"data": "livingSpace"},
                {"data": "house"},
                {"data": "apartmentOwner"},
                {"data": "meterPrice"}
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
    /////////////////////ClientTablereq
    $("#formClient").submit(function(event) {
        event.preventDefault();

        var table = $('#DTClient').DataTable( {
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTClient',
                "dataSrc": "",
                "data": function ( d ) {
                    d.idClient = $('#idClient').val();
                    d.name = $('#name').val();
                    d.surname = $('#surname').val();
                    d.patronymic = $('#patronymic').val();
                    d.dateOfBirth = $('#dateOfBirth').val();
                    d.phoneNumber = $('#phoneNumber').val();
                    d.email = $('#email').val();
                    d.gender = $('#gender').val();
                }
            },
            "columns": [
                { "data": "idClient" },
                { "data": "name" },
                { "data": "surname" },
                { "data": "patronymic" },
                { "data": "dateOfBirth" },
                { "data": "phoneNumber" },
                { "data": "email" },
                { "data": "gender" }
            ]
        });
        $('#DTClient tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            $("#buyer").val(data.idClient.toString());

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
    /////////////////////AGENTTablereq
    $("#formAgent").submit(function(event) {
        event.preventDefault();

        var table = $('#DTAgent').DataTable( {
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTAgent',
                "dataSrc": "",
                "data": function ( d ) {
                    d.idAgent = $('#idAgent').val();
                    d.name = $('#Aname').val();
                    d.surname = $('#Asurname').val();
                    d.patronymic = $('#Apatronymic').val();
                    d.percent = $('#Apercent').val();
                    d.phoneNumber = $('#AphoneNumber').val();
                }
            },
            "columns": [
                { "data": "idAgent" },
                { "data": "name" },
                { "data": "surname" },
                { "data": "patronymic" },
                { "data": "percent" },
                { "data": "phoneNumber" }
            ]
        });
        $('#DTAgent tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            $("#agent").val(data.idAgent.toString());

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
});