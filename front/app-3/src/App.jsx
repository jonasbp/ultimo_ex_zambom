import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { CadastraTime } from './times/CadastraTime'
import { ListaTimes } from './times/ListaTimes'
import { Link, Route, Routes } from 'react-router-dom'
import { Grid } from '@mui/material'

function App() {


  return (
    <>
      <h1>Hello World!</h1>
      <Grid container>
    
        <Grid item xs={4}>

          <Grid container>
            <Grid item xs={12}>
              <Link to='/'>Home</Link>   
            </Grid>
            <Grid item xs={12}>
              <Link to='/cadastrarTime'>Novo Time</Link> 
            </Grid>
            <Grid item xs={12}>
              <Link to='/listarTimes'>Listar Times</Link>
            </Grid>
          </Grid>


        </Grid>
        <Grid item xs={8}>
          <Routes>
            <Route path='/cadastrarTime' element={<CadastraTime />} />
            <Route path='/listarTimes' element={<ListaTimes/>} />
            <Route path='/cadastrarCampeonato' element={<cadastrarCampeonato/>} />
            <Route path='/listarCampeonato' element={<listarCampeonato/>} />
            <Route path='/cadastrarPartida' element={<cadastrarPartida/>} />
            <Route path='/listarPartida' element={<listarPartida/>} />



          </Routes>
        </Grid>
      </Grid>


      <h1>Hello World!</h1>
    </>
  )
}

export default App
