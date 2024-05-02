import { useEffect, useState } from "react"


export function ListaPartida() {

  const [data, setData] = useState([])

  const [nome, setNome] = useState()

  useEffect(() => {
    load()
  }, [])

  function load() {
    fetch('http://localhost:8080/partida', {
      method: 'GET'
    }).then(response => {
      return response.json()
    }).then(data => {
      setData(data)
    }).catch(response => {
      alert('Erro ao listar times!')
      alert(response.status)
    })
  }

  return(
    <>
        <div className="card">
            <table>
                <tbody>
                    <tr>
                    <td>Mandante</td>
                    <td>Visitante</td>
                    <td>Placar Mandante</td>
                    <td>Placar Visitante</td>
                    <td>Campeonato</td>
                    </tr>            
                    {
                    data.map((time, index) => {
                        return <tr key={index}>
                        <td>{time.mandante}</td>
                        <td>{time.visitante}</td>
                        <td>{time.placarMandante}</td>
                        <td>{time.placarVisitante}</td>
                        <td>{time.campeonato}</td>

                        </tr>
                    })

                    }
                </tbody>
            </table>

        </div>
      </>
  )


}