function pesquisar() {
    if ($('#usuarioPesquisa').val() !== "") {
        $.ajax({
            url: '/search/users?pesquisa=' + $('#usuarioPesquisa').val(),
            type: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function(resultado) {
                appendNewSearchOnResult(resultado);
            },
        });
    } else {
        alert('Campo não preenchido');
    }
}

function appendNewSearchOnResult(usuario) {
    $('.connectedSortable > .box:nth-child(0)').after(usuario);
}

function perseguir(idUsuario) {
        console.log(idUsuario);
        $.ajax({
            url: '/perseguir',
            type: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                idUsuario: idUsuario
            }),
            success: function(resultado) {
                $('#perseguir' + resultado).attr('disabled', 'disabled');
                $('#perseguir' + resultado).text('Perseguindo!');
            },
        });
    }