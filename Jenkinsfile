pipeline{
    
    agent any
    
    stages{
        
         stage("Build"){
             steps{
                 echo("It's first : Bild Project")
             }
         }
        
        stage("Run UTs"){
             steps{
                 echo("It's Second : Run UT's")
             }
         }
        
        stage("Deploy to Dev"){
             steps{
                 echo("It's Third : Dev Deployment")
             }
         }
        
        stage("Deploy to Qa"){
             steps{
                 echo("It's Fourth : Qa Deployment")
             }
         }
        
        stage("Run Automation Regression Test"){
             steps{
                 echo("It's Six  : Regression Test")
             }
         }
        
          stage("Run Automation On Stage"){
             steps{
                 echo("It's seven  : Stage Enviorment")
             }
         }
        
        
          stage("Run Automation On Production"){
             steps{
                 echo("It's eight  : Production Enviorment")
             }
         }
        
    }
    
    
        
    
}