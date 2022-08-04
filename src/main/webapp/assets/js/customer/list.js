let $table = $("#table");

function operateFormatter(value, row, index) {
  return [
    '<a class="update mr-2" href="javascript:void(0)" title="Update">',
    '<i class="far fa-edit fa-2x fa-fw"></i>',
    "</a>  ",
    '<a class="remove" href="javascript:void(0)" title="Remove">',
    '<i class="far fa-trash-alt fa-2x fa-fw"></i>',
    "</a>",
  ].join("");
}

window.operateEvents = {
  "click .update": function (e, value, row, index) {
    window.location.href = `/admin_dashboard/customer/update?id=${row.customerId}`;
  },
  "click .remove": function (e, value, row, index) {
    $("#deleteModal").modal("show");
    $("#deleteModalBtn").on("click", function () {
      window.location.href = `/admin_dashboard/customer/delete?id=${row.customerId}`;
    });
  },
};