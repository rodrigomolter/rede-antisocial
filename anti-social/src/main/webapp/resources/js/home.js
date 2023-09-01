$(function() {
    setInterval(function() {
        getPostagens();
    }, 5000);
});

function postarMensagem() {
    if ($('textarea, .textarea').val() !== "") {
        $.ajax({
            url: '/postar',
            type: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                mensagem: $('textarea, .textarea').val()
            }),
            success: function(resultado) {
                $('textarea, .textarea').val('');
                appendNewPostOnFeed(resultado);
            },
        });
    } else {
        alert('Campo não preenchido');
    }
}

function appendNewPostOnFeed(postagem) {
    $('.connectedSortable > .box:nth-child(1)').after(postagem);
}


function descurtir(idpost,descurtidas) {
        $.ajax({
            url: '/descurtir',
            type: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                idPostagem: idpost
            }),
            success: function(resultado) {
                $('#descurtidas' + idpost).attr('disabled', 'disabled');
                descurtidas++;
                $('#contadorDescurtidas'+idpost).text(descurtidas + ' pessoas descurtiram isso');
            },
        });
    }
    /*$(window).scroll(function()
    {
        var tamanhoTotalScroll = $(document).height() - $(window).height();
        var posicaoAtualScroll = $(window).scrollTop();

        if(tamanhoTotalScroll <= (posicaoAtualScroll + 700)){
            $('div#loadmoreajaxloader').show();
            console.log('chegou no fim do scroll')
        }
    });*/

function getPostagens() {
    $.ajax({
        url: '/atualiza/feed',
        type: 'GET',
        success: function(postagens) {
            $('#idfeedbox').children("#postagembox").remove();
            appendNewPostOnFeed(postagens);
        }
    });
}
