function getData()
{
    $.get("/data", (data, status)=>
    {
        fillTable(data);
    } );
}
function fillTable(data)
{
    var row = $("#content-table-row")
    row.empty();
    for (var i = 0; i < data.length; ++i) {
        
        var obj = data[i];
        var id = Object.keys(obj)[0];

        var dt = obj[id].data;
        var color = obj[id].color;
        row.append(`<tr>
        <th scope="row">${i + 1}</th>
        <td style="color:${color.toLowerCase()}">${id}</td>
        <td style="color:${color.toLowerCase()}">${dt}</td></tr>`);


        
    }
}