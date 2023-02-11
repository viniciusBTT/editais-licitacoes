var rows = 5;
    window.onload = () =>
    {
        for (checkboxOffset of document.getElementsByName('checkbox-page'))
        {
            var inputPage = document.getElementById('input-page');
            checkboxOffset.addEventListener('change', (e) => {
                /**
                 * 
                 * @param {offset} número de linhas, mais o número de linhas por página
                 * @param {page} número de linhas por página
                 * @return {undefined}
                 */
                
                inputPage.value = parseInt(e.target.value) - 1;
                datatable((rows * parseInt(inputPage.value)), 5);
            });
        }
        
    };
    
    function prevPage()
    {
        var inputPage = document.getElementById('input-page');
               
        if(inputPage.value === '0')
        {
            return ;
        }

        let prevVal = parseInt(inputPage.value) - 1;
        inputPage.value = prevVal;

        datatable(rows * parseInt(inputPage.value), 5);
    }
    
    function nextPage()
    {
        var inputPage = document.getElementById('input-page');
               
        datatable(rows * parseInt(inputPage.value), 5);

        let nextVal = parseInt(inputPage.value) + 1;

        inputPage.value = nextVal;
    }

    /**
     * retorna modal de solicitação
     * @param {type} codEdital
     * @return {undefined}
     */

    function requestEdital(codEdital)
    {
        let popup = document.getElementById('popup');
        axios({
            method: "get",
            url: `/edital/request/${codEdital}`
        }).then(function (response) {
            popup.innerHTML = response.data;

            let modal = document.getElementById('modal-' + codEdital);

            let form = document.getElementById('form-edital-request');
            form.addEventListener('submit', (e) => {
                e.preventDefault();

                let requisitionForm = new FormData(form);

                let checkbox = requisitionForm.get("radio");

                if (checkbox === "pf")
                {
                    let pessoaFisica = {
                        codPessoaFisica: null,
                        nomeCompleto: requisitionForm.get("nomeCompleto"),
                        telefone: requisitionForm.get("telefone"),
                        email: requisitionForm.get("email")
                    };

                    let pessoa = {
                        codPessoa: null,
                        pessoaFisica: pessoaFisica
                    };

                }
            });

            modal.classList.add('active');
        });
    }

    /**
     * fecha modal
     * @return {undefined}
     */
    function cancelRequest() {
        let popup = document.getElementById('popup');
        popup.innerHTML = "";
    }

    /**
     * troca o formulário de envio para o tipo de solicitante
     * @param {type} radio box
     * @return {undefined} toggle
     */
    function requesterToggle(radio)
    {
        let pfForm = document.getElementById('form-pf');
        let pjForm = document.getElementById('form-pj');
        let loading = document.getElementById('loading-requester');

        loading.removeAttribute("style");

        //se for pj
        if (radio.value === "pf")
        {
            pjForm.setAttribute("style", "display: none");
            setTimeout((e) => {
                loading.setAttribute("style", "display: none");
                pfForm.removeAttribute("style");
                document.getElementById('btn-requester-submit').removeAttribute("disabled");
            }, 1700);
            return;
        }

        pfForm.setAttribute("style", "display: none");
        setTimeout((e) => {
            loading.setAttribute("style", "display: none");
            pjForm.removeAttribute("style");
            document.getElementById('btn-requester-submit').removeAttribute("disabled");
        }, 1000);

        return;
    }

    function datatable(offset, rows)
    {
        let responseEditais = document.getElementById('table-editais');
        
        axios({
            method: "get",
            url: `/edital/request/findLimited/${offset}/${rows}`
        }).then(function (response) {
            responseEditais.innerHTML = response.data;
            
            const selectList = [];
            const notFoundElement = `
                <div class="br-item not-found">
                 <div class="container">
                  <div class="row">
                   <div class="col">
                    <p><strong>Ops!</strong> Não encontramos o que você está procurando!</p>
                   </div>
                  </div>
                 </div>
                </div>
               `;
            for (const brSelect of window.document.querySelectorAll('.br-select')) {
                const brselect = new core.BRSelect('br-select', brSelect, notFoundElement);
                for (checkboxOffset of document.getElementsByName('checkbox-page'))
                {
                    var inputPage = document.getElementById('input-page');
                    checkboxOffset.addEventListener('change', (e) => {
                        /**
                         * 
                         * @param {offset} número de linhas, mais o número de linhas por página
                         * @param {page} número de linhas por página
                         * @return {undefined}
                         */
                        
                        inputPage.value = parseInt(e.target.value) - 1;
                        datatable((rows * parseInt(inputPage.value)), 5);
                        
                    });
                }
                selectList.push(brselect);
            }           
        });
    }