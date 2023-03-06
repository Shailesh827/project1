import { useReducer } from "react";
export default function TrainerReg()
{
    const init={
        username:"",
        password:"",
        firstname:"",
        lastname:"",
        regno:"",
        address:"",
        phoneno:"",
        description:""
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

    var sendData=(e)=>{
        e.preventDefault();
        const reqOption={
            method:'POST',
            headers:{'content-type':'application/json'},
            body:JSON.stringify(info)

        }
        fetch('http://localhost:8080/regTrainer',reqOption)
        .then(resp=>{console.log(resp.ok);
            if(resp.ok)
                        return resp.json();
                    else
                        throw new Error("server Error");
                    }
             )
        
    }



    return(
        <>
        <h1>Trainer Registration</h1>
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
                <label htmlFor="regno" className="form-label">Enter Registraion no.:</label>
                <input type="text" className="form-control" id="regno" name="regno" value={info.regno}
                onChange={(e)=>{dispatch({type:'update',fld:'regno',val:e.target.value})}}/>
                <div id="regnohelp" className="form-text">valid regno</div>
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
                <label htmlFor="description" className="form-label">Enter description:</label>
                <input type="text" className="form-control" id="description" name="description" value={info.description}
                onChange={(e)=>{dispatch({type:'update',fld:'description',val:e.target.value})}}/>
                <div id="descriptionhelp" className="form-text">...</div>
            </div>
            
            <button type="submit" className="btn btn-primary md-3" name="login" onClick={(e)=>{sendData(e)}} >submit</button>
            <button type="reset" className="btn btn-primary md-3" name="login" onClick={()=>dispatch({type:'reset'})}>reset</button>
            
        </form>
        <p>{JSON.stringify(info)}</p>
        {/* <p>{msg}</p> */}
        
        
        
        
        
        
        </>
    )
    
    }