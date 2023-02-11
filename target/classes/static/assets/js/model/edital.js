var btnSelectFile = "";
var lastInputID = 0; //armazena o ultimo input adicionado

/* acoes necessarias para funcionar o formulario desta pagina*/
btnSelectFile = document.getElementById('btn-input-file'); //botao que chama o input typefile
        
btnSelectFile.addEventListener('click', (event) =>
{
    document.getElementById('attachment-' + lastInputID).click();
});

function showAttachments(inputFile)
{

    lastInputID += 1;

    const inputTypeFile = document.createElement('input');

    inputTypeFile.classList.add('upload-input');
    inputTypeFile.classList.add('multiple-input-file');
    inputTypeFile.id = `attachment-${lastInputID}`;
    inputTypeFile.type = 'file';
    inputTypeFile.name = 'attachments[]';
    inputTypeFile.setAttribute('onchange', 'showAttachments(this)');
    inputTypeFile.setAttribute('multiple', 'true');


    
    var files = document.getElementsByName("attachments[]");
    
    var filePreview = '';
    files.forEach((input) =>
    {
        //se houver mais de 1 arquivo
        if(input.files.length > 1)
        {   
            for(var i = 0; i < input.files.length; i++)
            {
                console.log(input.files.item(i));
                filePreview +=
                    `<span class="br-tag interaction mb-3" id="interaction-${lastInputID - 1}">
                        <i class="fas fa-file" aria-hidden="true"></i>
                        <span>${input.files.item(i).name}</span>
                        <button 
                        class="br-button" onclick="
                            document.getElementById('attachment-${lastInputID - 1}').remove(); 
                            document.getElementById('interaction-${lastInputID - 1}').remove(); 
                        "
                        type="button" aria-label="Fechar" data-dismiss="interaction01">
                        <i class="fas fa-times" aria-hidden="true"></i>
                        </button>
                    </span>`
            }
        }
        else
        {
            filePreview =
                `<span class="br-tag interaction mb-3" id="interaction-${lastInputID - 1}">
                    <i class="fas fa-file" aria-hidden="true"></i>
                    <span>${input.files[0].name}</span>
                    <button 
                    class="br-button" onclick="
                        document.getElementById('attachment-${lastInputID - 1}').remove(); 
                        document.getElementById('interaction-${lastInputID - 1}').remove(); 
                    "
                    type="button" aria-label="Fechar" data-dismiss="interaction01">
                    <i class="fas fa-times" aria-hidden="true"></i>
                    </button>
                </span>`
        }
    })
    
    document.getElementById('upload-list-attachments').innerHTML += filePreview;

    document.getElementById('multiple-input-files').appendChild(inputTypeFile);
  
}