function userRegister() {
    if ($('#idemail').val() === "" || $('#idsenha').val() === "" || $('#idnome').val() === "" || $("input[name='genero']:checked").val() === "") {
        $('#message').text("Alguns campos obrigatórios não foram preenchidos")
        $('.cadastro-fields').hide();
        $('.login-fields').fadeIn('slow');
    } else {
        $.ajax({
            url: '/cadastra/usuario',
            type: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                email: $('#idemail').val(),
                senha: $('#idsenha').val(),
                nome: $('#idnome').val(),
                localizacao: $('#idLocalizacao').val(),
                dataNascimento: $('#idDataNascimento').val(),
                genero: $("input[name='genero']:checked").val()
            }),
            success: function(resultado) {
                $('#message').text("Cadastrado com sucesso! Faça login!")
                $('.cadastro-fields').hide();
                $('.login-fields').fadeIn('slow');
            },
            error: function() {
                $('#message').text("Erro no servidor, tente novamente mais tarde")
                $('.cadastro-fields').hide();
                $('.login-fields').fadeIn('slow');
            }
        });
    }
};
