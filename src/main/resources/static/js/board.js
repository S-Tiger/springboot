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
            boardNo: $('#boardNo').val,
            title: $('#title').val(),
            content: $('#content').val(),
            author: $('#author').val

        };

        $.ajax({
            type: 'POST',
            url: '/board',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/boardList';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            boardNo: $('#boardNo').val(),
            title: $('#title').val(),
            content: $('#content').val(),
            author: $('#author').val
        };
        var boardNo = $('#boardNo').val();

        $.ajax({
            type: 'PUT',
            url: '/board/'+boardNo,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/boardList';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var boardNo = $('#boardNo').val();

        $.ajax({
            type: 'DELETE',
            url: '/board/'+boardNo,
            dateType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/boardList';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

};
main.init();

