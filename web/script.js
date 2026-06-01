let regioes = [
    {
        id: 1,
        nome: "Zona Rural Norte",
        cidade: "Ribeirão Preto",
        estado: "SP",
        tipoRisco: "Queimada",
        nivelRisco: "Alto",
        satelite: "Aqua"
    },
    {
        id: 2,
        nome: "Margem do Rio Central",
        cidade: "São Paulo",
        estado: "SP",
        tipoRisco: "Enchente",
        nivelRisco: "Médio",
        satelite: "Sentinel-2"
    },
    {
        id: 3,
        nome: "Área de Preservação Verde",
        cidade: "Manaus",
        estado: "AM",
        tipoRisco: "Desmatamento",
        nivelRisco: "Alto",
        satelite: "CBERS-4A"
    },
    {
        id: 4,
        nome: "Litoral Sul",
        cidade: "Santos",
        estado: "SP",
        tipoRisco: "Enchente",
        nivelRisco: "Médio",
        satelite: "Sentinel-2"
    }
];

let alertas = [
    {
        id: 1,
        regiao: "Zona Rural Norte",
        cidade: "Ribeirão Preto",
        tipo: "Risco de Queimada",
        descricao: "Temperatura elevada e baixa umidade detectadas por monitoramento orbital.",
        status: "Ativo",
        nivel: "Alto"
    },
    {
        id: 2,
        regiao: "Margem do Rio Central",
        cidade: "São Paulo",
        tipo: "Risco de Enchente",
        descricao: "Aumento do nível do rio identificado por dados simulados de satélite.",
        status: "Em análise",
        nivel: "Médio"
    },
    {
        id: 3,
        regiao: "Área de Preservação Verde",
        cidade: "Manaus",
        tipo: "Risco de Desmatamento",
        descricao: "Alteração na cobertura vegetal identificada por imagens orbitais.",
        status: "Ativo",
        nivel: "Alto"
    }
];

function carregarDadosSalvos() {
    const regioesSalvas = JSON.parse(localStorage.getItem("spaceguard_regioes")) || [];
    const alertasSalvos = JSON.parse(localStorage.getItem("spaceguard_alertas")) || [];

    regioes = [...regioes, ...regioesSalvas];
    alertas = [...alertas, ...alertasSalvos];
}

function salvarNovaRegiao(regiao) {
    const regioesSalvas = JSON.parse(localStorage.getItem("spaceguard_regioes")) || [];
    regioesSalvas.push(regiao);
    localStorage.setItem("spaceguard_regioes", JSON.stringify(regioesSalvas));
}

function salvarNovoAlerta(alerta) {
    const alertasSalvos = JSON.parse(localStorage.getItem("spaceguard_alertas")) || [];
    alertasSalvos.push(alerta);
    localStorage.setItem("spaceguard_alertas", JSON.stringify(alertasSalvos));
}

function classeRisco(nivel) {
    if (nivel === "Alto") {
        return "risco-alto";
    }

    if (nivel === "Médio") {
        return "risco-medio";
    }

    return "risco-baixo";
}

function carregarDashboard() {
    const totalRegioes = document.getElementById("total-regioes");
    const totalAlertas = document.getElementById("total-alertas");
    const totalRiscoAlto = document.getElementById("total-risco-alto");
    const listaAlertas = document.getElementById("lista-alertas-dashboard");

    if (!totalRegioes || !totalAlertas || !totalRiscoAlto || !listaAlertas) {
        return;
    }

    totalRegioes.textContent = regioes.length;
    totalAlertas.textContent = alertas.filter(alerta => alerta.status !== "Resolvido").length;
    totalRiscoAlto.textContent = regioes.filter(regiao => regiao.nivelRisco === "Alto").length;

    listaAlertas.innerHTML = "";

    alertas.forEach(alerta => {
        const card = document.createElement("article");
        card.className = "alerta-card";

        card.innerHTML = `
            <h3>${alerta.tipo}</h3>
            <p><strong>Região:</strong> ${alerta.regiao}</p>
            <p><strong>Cidade:</strong> ${alerta.cidade}</p>
            <p>${alerta.descricao}</p>
            <span class="badge ${classeRisco(alerta.nivel)}">${alerta.nivel}</span>
        `;

        listaAlertas.appendChild(card);
    });
}

function renderizarRegioes(lista) {
    const container = document.getElementById("lista-regioes");

    if (!container) {
        return;
    }

    container.innerHTML = "";

    if (lista.length === 0) {
        container.innerHTML = "<p>Nenhuma região encontrada.</p>";
        return;
    }

    lista.forEach(regiao => {
        const card = document.createElement("article");
        card.className = "regiao-card";

        card.innerHTML = `
            <h3>${regiao.nome}</h3>
            <p><strong>Cidade:</strong> ${regiao.cidade} - ${regiao.estado}</p>
            <p><strong>Tipo de risco:</strong> ${regiao.tipoRisco}</p>
            <p><strong>Satélite:</strong> ${regiao.satelite}</p>
            <span class="badge ${classeRisco(regiao.nivelRisco)}">${regiao.nivelRisco}</span>
        `;

        container.appendChild(card);
    });
}

function carregarMonitoramento() {
    const campoBusca = document.getElementById("campo-busca");
    const filtroRisco = document.getElementById("filtro-risco");

    if (!campoBusca || !filtroRisco) {
        return;
    }

    function filtrarRegioes() {
        const textoBusca = campoBusca.value.toLowerCase();
        const riscoSelecionado = filtroRisco.value;

        const resultado = regioes.filter(regiao => {
            const combinaTexto =
                regiao.nome.toLowerCase().includes(textoBusca) ||
                regiao.cidade.toLowerCase().includes(textoBusca);

            const combinaRisco =
                riscoSelecionado === "todos" ||
                regiao.nivelRisco === riscoSelecionado;

            return combinaTexto && combinaRisco;
        });

        renderizarRegioes(resultado);
    }

    campoBusca.addEventListener("input", filtrarRegioes);
    filtroRisco.addEventListener("change", filtrarRegioes);

    renderizarRegioes(regioes);
}

function carregarFormulario() {
    const form = document.getElementById("form-alerta");
    const mensagem = document.getElementById("mensagem-sucesso");

    if (!form || !mensagem) {
        return;
    }

    form.addEventListener("submit", function(event) {
        event.preventDefault();

        const nomeRegiao = document.getElementById("regiao").value;
        const cidade = document.getElementById("cidade").value;
        const tipo = document.getElementById("tipo").value;
        const nivel = document.getElementById("nivel").value;
        const satelite = document.getElementById("satelite").value;
        const descricao = document.getElementById("descricao").value;

        const novaRegiao = {
            id: Date.now(),
            nome: nomeRegiao,
            cidade: cidade,
            estado: "SP",
            tipoRisco: tipo,
            nivelRisco: nivel,
            satelite: satelite
        };

        const novoAlerta = {
            id: Date.now(),
            regiao: nomeRegiao,
            cidade: cidade,
            tipo: "Risco de " + tipo,
            descricao: descricao,
            status: "Ativo",
            nivel: nivel
        };

        salvarNovaRegiao(novaRegiao);
        salvarNovoAlerta(novoAlerta);

        mensagem.style.display = "block";
        form.reset();

        setTimeout(() => {
            mensagem.style.display = "none";
        }, 4000);
    });
}

carregarDadosSalvos();
carregarDashboard();
carregarMonitoramento();
carregarFormulario();