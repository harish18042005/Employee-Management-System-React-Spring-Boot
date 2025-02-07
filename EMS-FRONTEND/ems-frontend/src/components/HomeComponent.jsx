import React from 'react'
import { useNavigate } from 'react-router-dom'

function HomeComponent() {

    const navigator = useNavigate();

    function homeClick(){
        navigator("/employees")
    }

  return (
    <div className='home-div'>
        
        <button className='home-button' onClick={homeClick}>START</button>
    </div>
  )
}

export default HomeComponent