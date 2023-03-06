import { useReducer } from "react";
import { useNavigate } from "react-router-dom";
export default function BuyerReg()
{
    const init={
        username:"",
        password:"",
        firstname:"",
        lastname:"",
        email:"",
        address:"",
        phoneno:"",
        adharno:""
    }

    const reducer=(state,action)=>{
        switch(action.type)
        {
            case 'update':
                return {...state,[action.fld]:action.val}
            case 'reset':
                return init;
        }
    }

    const [info,dispatch]=useReducer(reducer,init);
    const navigate = useNavigate();
    var sendData=(e)=>{
        e.preventDefault();
        const reqOption={
            method:'POST',
            headers:{'content-type':'application/json'},
            body:JSON.stringify(info)

        }
        fetch("http://localhost:8080/regBuyer",reqOption)
        .then(resp=>{console.log(resp.ok);
            if(resp.ok)
                        return resp.json();
                    else
                        throw new Error("server Error");
                    }
             )
            .then(obj => {
                 alert("Registraion succsesful try login");
                 navigate('/');
            })
            .catch((error)=> alert("server error"))
    }



    return(
        <>
        <h1>Buyer Registration</h1>
        <form>
            <div className="mb-3">
                <label htmlFor="username" className="form-label">Enter Username:</label>
                <input type="text" className="form-control" id="username" name="username" value={info.username}
                onChange={(e)=>{dispatch({type:'update',fld:'username',val:e.target.value})}}/>
                <div id="usernamehelp" className="form-text">valid username</div>
            </div>

            <div className="mb-3">
                <label htmlFor="password" className="form-label">Enter password:</label>
                <input type="text" className="form-control" id="password" name="password"value={info.password}
                onChange={(e)=>{dispatch({type:'update',fld:'password',val:e.target.value})}} />
                <div id="usernamehelp" className="form-text">....</div>
            </div>

            

            <div className="mb-3">
                <label htmlFor="firstname" className="form-label">Enter firstname:</label>
                <input type="text" className="form-control" id="firstname" name="firstname"value={info.firstname}
                onChange={(e)=>{dispatch({type:'update',fld:'firstname',val:e.target.value})}} />
                <div id="usernamehelp" className="form-text">....</div>
            </div>

            <div className="mb-3">
                <label htmlFor="lastname" className="form-label">Enter lastname:</label>
                <input type="text" className="form-control" id="lastname" name="lastname" value={info.lastname}
                onChange={(e)=>{dispatch({type:'update',fld:'lastname',val:e.target.value})}}/>
                <div id="usernamehelp" className="form-text">...</div>
            </div>

            <div className="mb-3">
                <label htmlFor="email" className="form-label">Enter email:</label>
                <input type="text" className="form-control" id="email" name="email" value={info.email}
                onChange={(e)=>{dispatch({type:'update',fld:'email',val:e.target.value})}}/>
                <div id="emailhelp" className="form-text">valid email</div>
            </div>

            <div className="mb-3">
                <label htmlFor="address" className="form-label">Enter address:</label>
                <input type="text" className="form-control" id="address" name="address"value={info.address}
                onChange={(e)=>{dispatch({type:'update',fld:'address',val:e.target.value})}} />
                <div id="addresshelp" className="form-text">....</div>
            </div>

            

            <div className="mb-3">
                <label htmlFor="phoneno" className="form-label">Enter phoneno:</label>
                <input type="text" className="form-control" id="phoneno" name="phoneno"value={info.phoneno}
                onChange={(e)=>{dispatch({type:'update',fld:'phoneno',val:e.target.value})}} />
                <div id="phonenohelp" className="form-text">....</div>
            </div>

            <div className="mb-3">
                <label htmlFor="adharno" className="form-label">Enter adharno:</label>
                <input type="text" className="form-control" id="adharno" name="adharno" value={info.adharno}
                onChange={(e)=>{dispatch({type:'update',fld:'adharno',val:e.target.value})}}/>
                <div id="adharnohelp" className="form-text">...</div>
            </div>
            <button type="submit" className="btn btn-primary md-3" name="login" onClick={(e)=>{sendData(e)}} >submit</button>
            <button type="reset" className="btn btn-primary md-3" name="login" onClick={()=>dispatch({type:'reset'})}>reset</button>
            
        </form>
        <p>{JSON.stringify(info)}</p>
        {/* <p>{msg}</p> */}
        
        
        
        
        
        
        </>
    )
    
    }