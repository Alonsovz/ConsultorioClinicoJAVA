$('document').ready(function(){
    
    $(".datos").DataTable({
        colReorder : true,
        responsive:true,
        language: {
           "url": "//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json" 
           
        },
       "lengthMenu": [ 5, 10, 50, 75, 100 ]
    }); 
    
    
    /*
     $("#datos").DataTable({
        colReorder: true,
        language: {
           "url": "//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json" 
           
        },
        paging: true,
        "lengthMenu": [ 10, 25, 50, 75, 100 ],
        "pageLength": 50,
        responsive: true
    });
    
    */
    
});


