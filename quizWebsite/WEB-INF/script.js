let questionNumber = 7;
dewewewe
addEventListnerOption();
console.log("juuuuu");
let isSelected = false;
function optionChoosed(option)
{
    // when the option is choosed we need to display the next button 
    
    // removing already choosen one
    // removeChoosenOption();
    

    removeChoosenOption(option.id);       
    // making the current choosen option black
    option.classList.add("active");
    
    
        
    // and the option is actived

}

// adding eventListner for all options
function addEventListnerOption()
{
    // 4 options
    for(let questionId = 1;questionId <= questionNumber;questionId++)
    {

    
    for(let i = 1;i<=3;i++)
    {
        let option = document.getElementById( questionId+"-op-" + i);
        option.addEventListener("click",()=>
        {
            
            optionChoosed(option);
        })
    
    }
}
}

function removeChoosenOption(questionId)
{
    
    for(let i = 1;i<=4;i++)
    {
        let option = document.getElementById(questionId[0] +"-op-" + i);
        option.classList.remove("active");
    }

}