$(document).ready( function () {
/////Автозагрузка при открытии аккордеона
    $('#headingOne').on('click',function(event){
        $("#btnUserFilter").click();
    });
    $('#headingTwo').on('click',function(event){
        $("#btnUserRoleFilter").click();
    });
    $('#headingThree').on('click',function(event){
        $("#btnJournalEventFilter").click();
    });
    $('#headingFour').on('click',function(event){
        $("#btnJournalErrorFilter").click();
    });
    //////////////////////
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
        $('#DTUserView tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            document.location = './viewAgent?User=' + data.idUser;
        });
    });
    ////////////////////////////////
    $("#formUserRole").submit(function(event){
        event.preventDefault();
        const table = $('#DTUserRoleView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTUserRoleView',
                "dataSrc": "",
                "data": function (d) {
                    d.idRole = $('#idRole').val();
                    d.nameRole = $('#RnameRole').val();
                }
            },
            "columns": [
                {"data": "idRole"},
                {"data": "nameRole"},
                {"data": "description"}
            ]
        });
        $('#DTUserRoleView tbody').on('click', 'tr', function () {

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
        ////////////////////////////
    $("#formJournalEventView").submit(function(event){
        event.preventDefault();
        const table = $('#DTJournalEventView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTJournalEventView',
                "dataSrc": "",
                "data": function (d) {
                    d.idEvent = $('#idEvent').val();
                    d.nameEvent = $('#nameEvent').val();
                    d.nameFunction = $('#nameFunction').val();
                    d.userRequest = $('#userRequest').val();
                    d.data = $('#dataEvent').val();
                }
            },
            "columns": [
                {"data": "idEvent"},
                {"data": "nameEvent"},
                {"data": "nameFunction"},
                {"data": "userRequest"},
                {"data": "dateEvent"},
                {"data": "data"}
            ]
        });
        $('#DTJournalEventView tbody').on('click', 'tr', function () {

            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
    //////////////////////////////////////////////////////
    $("#formJournalErrorView").submit(function(event){
        event.preventDefault();
        const table = $('#DTJournalErrorView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTJournalErrorView',
                "dataSrc": "",
                "data": function (d) {
                    d.idError = $('#idError').val();
                    d.nameError = $('#nameError').val();
                    d.nameFunction = $('#nameFunctionEr').val();
                    d.userRequest = $('#userRequestEr').val();
                }
            },
            "columns": [
                {"data": "idError"},
                {"data": "nameError"},
                {"data": "nameFunction"},
                {"data": "userRequest"},
                {"data": "dateError"},
                {"data": "description"}
            ]
        });
        $('#DTJournalErrorView tbody').on('click', 'tr', function () {

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