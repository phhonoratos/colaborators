import React from 'react';
import { withRouter} from 'react-router-dom';
import axios from 'axios';
import './styles.css'
import { Formik, Field } from 'formik';
import { BASE_URL } from 'app/utils/requests';

class Cadastro extends React.Component {

    state = {
        nome: '',
        email: '',
        pais: '',
        estado: '',
        municipio: '',
        cep: '',
        rua: '',
        numero: '',
        complemento: '',
        cpf: '',
        pis: '',
        senha: '',
        senhaRepeticao: '',
        msgErro: null
    }

    validar(){
        const msgs = [];

        if(!this.state.nome){
            msgs.push('O campo NOME é obrigatório.')
        }

        if(this.state.nome.length < 4){
            msgs.push('O campo NOME deve conter pelo menos 4 caracteres.')
        }

        if(!this.state.email) {
            msgs.push('O campo EMAIL é obrigatório.')
        } else if(!this.state.email.match(/^[a-z0-9.]+@[a-z0-9]+\.[a-z]/)) {
            msgs.push('Informe um EMAIL válido.')
        }

        if(!this.state.cpf) {
            msgs.push('O campo CPF é obrigatório.')
        }

        if(!this.state.cep) {
            msgs.push('O campo CEP é obrigatório.')
        }
        
        if(!this.state.rua) {
            msgs.push('O campo RUA é obrigatório.')
        }

        if(!this.state.numero) {
            msgs.push('O campo NÚMERO é obrigatório.')
        }

        if(!this.state.municipio) {
            msgs.push('O campo CIDADE é obrigatório.')
        }

        if(!this.state.estado) {
            msgs.push('O campo UF/ESTADO é obrigatório.')
        }

        if(!this.state.pais) {
            msgs.push('O campo PAÍS é obrigatório.')
        }

        if(!this.state.pis) {
            msgs.push('O campo PIS é obrigatório.')
        }

        if(!this.state.senha || !this.state.senhaRepeticao) {
            msgs.push('Informe a SENHA 2x.')
        } else if(this.state.senha !== this.state.senhaRepeticao) {
            msgs.push('As SENHAS não conferem. Por favor digite novamente e confirme.')
        }

        return msgs;
    }

    cadastrar = () => {
        const msgs = this.validar();

        if(msgs && msgs.length > 0) {
            msgs.forEach((msg, index) => {
                alert(msg)
            });
            return false;
        }

        axios.post(`${BASE_URL}/colaborators`, {
            nome: this.state.nome,
            email: this.state.email,
            pais: this.state.pais,
            estado: this.state.estado,
            municipio: this.state.municipio,
            cep: this.state.cep,
            rua: this.state.rua,
            numero: this.state.numero,
            complemento: this.state.complemento,
            cpf: this.state.cpf,
            pis: this.state.pis,
            senha: this.state.senha,
            senhaRepeticao: this.state.senhaRepeticao
        }).then(response => {
            alert('Cadastro realizado com sucesso!')
            this.props.history.push('/')
        }).catch( erro => {
            alert(erro.response.data)
        })
    }

    cancelar = () => {
        this.props.history.push('/')
    }

    onBlurCep(e) {
        const {value} = e.target
        const cep = value.replace(/[^0-9]/g,'')

        if(cep?.length !== 8) {
            return;
        }

        fetch(`https://viacep.com.br/ws/${cep}/json/`)
            .then((response) => response.json())
            .then((data) => {
                this.setState({rua: data.logradouro})
                this.setState({municipio: data.localidade})
                this.setState({estado: data.uf})
            })
    }

    render() {
        return (
            <div className="container">
                <Formik>
                    <div className="formulario">
                        <div className="card-header">
                            <h5>Novo cadastro de usuário</h5>
                        </div>
                        <div className="card-body">
                            <div className="form-group mt-4 pack">
                                <Field type="text"
                                    value={this.state.nome}
                                    onChange={e => this.setState({ nome: e.target.value })}
                                    className="form-control nome"
                                    placeholder="Nome completo" />
                                <Field type="email"
                                    value={this.state.email}
                                    onChange={e => this.setState({ email: e.target.value })}
                                    className="form-control email"
                                    placeholder="Email" />
                                <Field type="number"
                                    value={this.state.cpf}
                                    onChange={e => this.setState({ cpf: e.target.value })}
                                    className="form-control cpf"
                                    placeholder="CPF (somente números)" />
                            </div>
                            <div className="form-group mt-4 pack">
                                <Field type="number"
                                    value={this.state.cep}
                                    onChange={e => this.setState({ cep: e.target.value })}
                                    className="form-control cep"
                                    placeholder="CEP (somente números)"
                                    onBlur={(e) => this.onBlurCep(e)} />
                                <Field type="text"
                                    value={this.state.rua}
                                    onChange={e => this.setState({ rua: e.target.value })}
                                    className="form-control rua"
                                    placeholder="Logradouro / Rua"
                                    name="logradouro" />
                                <Field type="number"
                                    value={this.state.numero}
                                    onChange={e => this.setState({ numero: e.target.value })}
                                    className="form-control numero"
                                    placeholder="Número" />
                            </div>
                            <div className="form-group mt-4 pack">
                                <Field type="text"
                                    value={this.state.complemento}
                                    onChange={e => this.setState({ complemento: e.target.value })}
                                    className="form-control complemento"
                                    placeholder="Complemento" />
                                <Field type="text"
                                    value={this.state.municipio}
                                    onChange={e => this.setState({ municipio: e.target.value })}
                                    className="form-control cidade"
                                    placeholder="Cidade"
                                    name="cidade" />
                                <Field type="text"
                                    value={this.state.estado}
                                    onChange={e => this.setState({ estado: e.target.value })}
                                    className="form-control estado"
                                    placeholder="UF / Estado"
                                    name="uf" />
                            </div>
                            <div className="form-group mt-4 packtwo">
                                <Field type="text"
                                    value={this.state.pais}
                                    onChange={e => this.setState({ pais: e.target.value })}
                                    className="form-control pais"
                                    placeholder="País" />
                                <Field type="number"
                                    value={this.state.pis}
                                    onChange={e => this.setState({ pis: e.target.value })}
                                    className="form-control pis"
                                    placeholder="PIS (somente números)" />
                            </div>
                            <div className="form-group mt-4 packtwo">
                                <Field type="password"
                                    value={this.state.senha}
                                    onChange={e => this.setState({ senha: e.target.value })}
                                    className="form-control senha"
                                    placeholder="Senha" />
                                <Field type="password"
                                    value={this.state.senhaRepeticao}
                                    onChange={e => this.setState({ senhaRepeticao: e.target.value })}
                                    className="form-control repsenha"
                                    placeholder="Confirme a senha" />
                            </div>
                            <div className="pack">
                                <button className="btn btn-danger mt-4 cancelar" onClick={this.cancelar}>Cancelar</button>
                                <button className="btn btn-success mt-4" onClick={this.cadastrar}>Cadastrar</button>
                            </div>
                        </div>
                    </div>
                </Formik>
            </div>
        )
    }
}

export default withRouter(Cadastro);