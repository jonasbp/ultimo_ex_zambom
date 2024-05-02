import { Fragment, useState } from "react"
import { Button, Grid, IconButton, Snackbar } from '@mui/material';
import { ItemForm } from "./ItemForm";


export function CadastrarPartida() {

    const [mandante, setMandante] = useState('')
    const [visitante, setVisitante] = useState('')
    const [placarMandante, setPlacarMandante] = useState('')
    const [placarVisitante, setPlacarVisitante] = useState('')
    const [campeonato, setCampeonato] = useState('')
    

    const [open, setOpen] = useState(false)

    const [message, setMessage] = useState()

    const handleClose = (event, reason) => {
        if (reason === 'clickaway') {
          return;
        }
    
        setOpen(false);
    };

    const action = (
        <Fragment>
          <Button color="secondary" size="small" onClick={handleClose}>
            UNDO
          </Button>
          <IconButton
            size="small"
            aria-label="close"
            color="inherit"
            onClick={handleClose}
          >
          </IconButton>
        </Fragment>
      );

    function click() {
        let data = {
          'nome': nome,
          'identificador': identificador,
          'estado': estado,
          'estadio': estadio
        }
    
        fetch('http://localhost:8080/partida', {
          method: 'POST',
          body: JSON.stringify(data),
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => {
            if (!response.ok) {
                // error processing
                throw 'Error';
            }
          setOpen(true)
          setMessage("Partida cadastrado com sucesso")
          //load()
        }).catch(response => {
            setOpen(true)
            setMessage('erro no cadastro da partida!')
        })
    }

    return (
        <>
            <div className="card">

                <Grid container columnSpacing={2} rowSpacing={1}>
                    <ItemForm label={"mandante:"} value={mandante} set={setMandante}></ItemForm>
                    <ItemForm label={"visitante:"} value={visitante} set={setVisitante}></ItemForm>
                    <ItemForm label={"placarMandante:"} value={placarMandante} set={setPlacarMandante}></ItemForm>
                    <ItemForm label={"placarVisitante:"} value={placarVisitante} set={setPlacarVisitante}></ItemForm>
                    <ItemForm label={"campeonato:"} value={campeonato} set={setCampeonato}></ItemForm>
                </Grid>
                <Button variant="outlined" onClick={() => click()}>Cadastrar</Button>

            </div>
            <Snackbar
                open={open}
                autoHideDuration={6000}
                onClose={handleClose}
                message={message}
                action={action}
            ></Snackbar>
        </>
    )

}