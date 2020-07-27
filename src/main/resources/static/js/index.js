var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
                  _this.save();
              });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });


    },

    save : function () {
        var data = {
            name: $('#name').val(),
            id: $('#id').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/memberTest',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            name: $('#name').val(),
            id: $('#id').val(),
        };
        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/memberTest'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/memberTest'+id,
            dateType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('회원이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

};
main.init();

