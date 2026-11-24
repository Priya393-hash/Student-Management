package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.data.domain.Sort;

//import org.springframework.web.bind.annotation.PutMapping;
///import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import java.util.List;
//import java.util.List;
//import java.util.Map;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Optional;
//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("/students")
@RestController 
public class HelloController {


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    @GetMapping("/about")
    public String spring(){
        return "I am learning spring boot";
    }
     @GetMapping("/student")
    public Student student(){
        return new Student("priya","Java","34","priys@emil.com",1l); //JSON response it will convert object into JSON data
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Hello" + name;
    }
    @GetMapping("/greet1/{name}")
    public String greet1(@PathVariable String name ){
        return "Hello : " +  name;
    }
    /*@PostMapping("/Student")
    public Student centerStudent(@RequestBody Student student){
        return student;
    }*/
    /*@GetMapping("/student1")
    public  List<Student> student1(){
        return List.of(
            new Student("Priya", "java", "20","priys@emil.com"),
            new Student("Rahul", "c", "21","priys@emil.com"),
            new Student("Megha", "c++", "22","priys@emil.com")
        );
    }*/

    
    //private List<Student> student1s = new ArrayList<>(); 
    /*@PostMapping("/Students")
    public Student cStudent(@RequestBody Student student){
        student1s.add(student);
        return student;
    }*/

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public HelloController(StudentRepository studentRepository, StudentService studentService){
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    
    /*@GetMapping("/students")
    public List<Student> getStudents(){
        //students.add(student);
        //return student; jab ye private List<Student> student1s = new ArrayList<>();   
        return studentRepository.findAll();
    }*/


    
    /*@PutMapping("/students/{index}")
    public Student updaStudent(
        @PathVariable int index,
        @RequestBody Student student
    ){
        student1s.set(index, student);
        return student;
    }*/

   
   /*  @DeleteMapping("/students/{index}")
    public ResponseEntity<String> deleStudent(@PathVariable int index){

        if(index<0 || index >= student1s.size()){
           return ResponseEntity.status(404).body("Student not found");
        }
        student1s.remove(index);
        return ResponseEntity.ok("Student deletedd");
    }*/
    @GetMapping("/test-error")
    public String Exerror(){
        int[] numbers = {10,20,30};
        return String.valueOf(numbers[10]);
    }
    /*@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexError(){
        return ResponseEntity
            .status(404)
            .body("invalid array index");
    }*/

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student){
       
        return studentRepository.save(student);
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));
        return errors;
    }*/


    //Database se id ke through specific data lena ho.
    /*@GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id).orElse(null);
        //findById() optinal<Student> return kare ga directly Student nahi
    }*/

    // agar data id ke through nahi mila it means agar wo id ho hi nahi
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        // Optional<Student> means = maybe Studetn mile ya na mile
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().build();
    }

    //id ke through database me data update karenge PutMapping se
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent){
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isPresent()){
            updatedStudent.setId(id);
            Student savedStudent = studentRepository.save(updatedStudent);
            return ResponseEntity.ok(savedStudent);
        }
        return ResponseEntity.notFound().build();
    }

    //id ke through database me data delete karenge 
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("student deleted");
        }
        return ResponseEntity.notFound().build();
    }

     //esistsById() only true and fale return karega id hai ya nahi bas yahi check karta hai.
    //boolean exists = studentRepository.existsById(1l);

    //Student ka actudal data chahiye tab
    //studentRepository.findById(id);

    //ye database me total students ko count kar ke batata hai.
    //studentRepository.count();

    //ye database ki saari student records ko delete kar deta hai
    //studentRepository.deleteALL();

    //particular id delete karna ho to 
    //studentRepository.deleteBYId(id);

    //saare students ko lena ho tab
    //studentRepository.findAll();

    //ek student id ke lena ho tab
    //studentRepository.findById(id);

    //agar multiple specific ids ke students chahiye to 
    //studentRepository.findAllById(ids)
    /*ex:List<Long> ids = List.of(1l,3l);
        List<Student> students = studentRepository.findAllById(ids);    
    */
    
    //findByName(String name) se student ka name dega
    @GetMapping("/students/search/name")
    public List<Student> searchName(@RequestParam String name){
        return studentRepository.findByName(name);
    }
    //Multiple conditions. jaise Name bhi match hona chahiy AND skill bhi match honi chahiye isliye findByNameAndSkill likhe
    @GetMapping("/students/search")
    public List<Student> searchStudents(@RequestParam String name,@RequestParam String skill ){
        return studentRepository.findByNameAndSkill(name, skill);
    }

    //findBySkill(String skill) student table me jiski skill given value ke equal hai, un sab students ko lao.
    @GetMapping("/students/search/skill")
    public List<Student> searchSkill(@RequestParam String skill){
        return studentRepository.findBySkill(skill);
    }

    //findByAgeGreaterThan: aise students do jinki age given age se greater ho
    @GetMapping("/students/age")
    public List<Student> searchAge(@RequestParam int age){
        return studentRepository.findByAgeGreaterThan(age);
    }

    //findByAgeGreaterThanEqual: agar jo age liye hai usko v check karna ho to, equal se lekar grater tak
    @GetMapping("/students/age-min")
    public List<Student> searchByMinAge(@RequestParam int age){
        return studentRepository.findByAgeGreaterThanEqual(age);
    }
    
    //isse sara data aye ga 
    @GetMapping ("/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    //findByAgeLessThan: jo age diya hai usse kam do
    @GetMapping("/students/age-max")
    public List<Student> searchByMaxAge(@RequestParam int age){
        return studentRepository.findByAgeLessThan(age);
    }

    //findByAgeLessThanEqual: jo age diya hau usse le kar kam wale age tak do
    @GetMapping("/students/age-equal")
    public List<Student> searchByMaxAgeEqual(@RequestParam int age){
        return studentRepository.findByAgeLessThanEqual(age);
    }
    //findByNameContaining() se jo searching name exixting hai wo aage ga
    @GetMapping("/students/search-name")
    public List<Student> searchByNameContaining(@RequestParam String name){
        return studentRepository.findByNameContaining(name);
    }

    //bich ke age ko find karna range ke bich
    @GetMapping("/students/age-between")
    public List<Student> searchByAgeBetween(@RequestParam int minAge,
        @RequestParam int maxAge){
            return studentRepository.findByAgeBetween(minAge, maxAge);
        }
    
    //students ko sort karke fetch karenge and ages ascending order me aaye ga and decending order me ages aaye ga
    @GetMapping("/students/sorted")
    public List<Student> getSortedStudents(){
        //return studentRepository.findAll(Sort.by("age").ascending());
        return studentRepository.findAll(Sort.by("age").descending());
    }

    //DTO banye response bhejne ke liye ye only specific result hi bhejega like name and skill but niche wala id api sab bhejaga.
    
    @GetMapping("/students/{id}/details")
    public StudentResponse getStudentResponse(@PathVariable Long id){
        
        return studentService.getStudentResponse(id);
    }
    // ye response me sab bheje ga like student ke sare filed.
   /*  @GetMapping ("/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id){
        StudentResponse student = studentService.getStudentResponse(id);
        return ResponseEntity.ok(student);
    }*/

    //Logger ek interface hai jo logging messages record karne ke methods provide karta hai.
    //LoggerFactory ek class hai 
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping ("/{id}")
    public ResponseEntity<StudentResponse> checkStudentLogger(@PathVariable Long id){
        logger.info("Fetching student with ID: {}", id);
        StudentResponse student = studentService.getStudentResponse(id);
        logger.info("Student fetched successfully");
        System.out.println("print test");
        return ResponseEntity.ok(student);
    }

    
}
