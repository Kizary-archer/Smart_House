$(document).ready( function () {
/////Автозагрузка при открытии аккордеона
    $('#headingOne').on('click',function(event){
    //////////////////////
        const table = $('#DTUserRequestView').DataTable({
            destroy: true,
            'ajax': {
                'type': 'POST',
                'url': './DTJournalUserRequestView',
                "dataSrc": "",
                "data": function (d) {
                    d.idUser = $('#idUser').val();
                }
            },
            "columns": [
                {"data": "idRequest"},
                {"data": "login"},
                {"data": "nameEvent"},
                {"data": "dateRequest"},
                {"data": "statusRequest"}
            ]
        });
    });
    ////////////////////////////////
});