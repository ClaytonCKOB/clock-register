import { Routes, Route } from 'react-router-dom';
import Login from './pages/Login';
import Interval from './pages/list/Interval';


function App() {

  return (
    <>
      <Routes>
        <Route path="/" element={<Login />}/>
        <Route path="/list/interval" element={<Interval/>}/>
      </Routes>
    </>
  )
}

export default App
