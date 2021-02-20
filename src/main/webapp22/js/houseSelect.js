$(document).ready( function () {
    var table;

    $("#formSearchHouse").submit(function(event) {
        event.preventDefault();
        //window.location.reload();
       /* var res;
        var formData = $("#formSearchHouse").serialize();
        $.post('./searchHouse',formData,function(data) {
            res = jQuery.parseJSON(data);
        });*/


       /* if ( $.fn.dataTable.isDataTable( '#tablehouses' ) ) {
            $('#tablehouses').DataTable().destroy();
        }*/
        table = $('#tablehouses').DataTable( {
            destroy: true,
           /* 'retrieve': true,
            'paging': false,
            'processing': true,
            'serverSide': true,*/
            'ajax': {
                'type': 'POST',
                'url': './searchHouse',
                "dataSrc": "",
                "data": function ( d ) {
                    d.idHouse = $('#idHouse').val();
                    d.numberHouse = $('#numberHouse').val();
                    d.nameSeries = $('#nameSeries').val();
                    d.nameStreet = $('#nameStreet').val();
                    d.nameDistrict = $('#nameDistrict').val();
                    d.nameCity = $('#nameCity').val();
                }

            },
            "columns": [
                { "data": "idHouse" },
                { "data": "numberHouse" },
                { "data": "nameSeries" },
                { "data": "nameStreet" },
                { "data": "nameDistrict" },
                { "data": "nameCity" }
            ]
        });
        $('#tablehouses tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            $("#house").val(data.idHouse.toString());

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