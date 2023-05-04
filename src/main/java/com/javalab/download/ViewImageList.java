package com.javalab.download;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * upload 폴더에 있는 이미지 파일들의 목록을 취합하는 서블릿.
 */
@WebServlet("/imageList.do")
public class ViewImageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
						throws ServletException, IOException {

		 // 1. webapp 밑에 있는 upload 폴더의 이미지 목록 취합
        String path = this.getServletContext().getRealPath("/upload");
        
        // 2. 파일 객체 생성
        File folder = new File(path);
        
        // 3. 파일 객체에서 파일 리스트 추출해서 File Type 배열에 저장
        File[] files = folder.listFiles();
        
        // 4. 이미지 목록을 담을 ArrayList
        List<String> imageList = new ArrayList<String>();
        
        // 5. 이미지 목록의 url을 만들어서 ArrayList에 저장
        for (File file : files) {
            if (file.isFile() && isImage(file)) {
                String fileName = file.getName();
                // 해당 파일을 찾아올 수 있는 url 생성
                String filePath = request.getContextPath() + "/upload/" + fileName;
                System.out.println("filePath : " + filePath);
                // 이미지 목록 ArrayList에 추가
                imageList.add(filePath);
            }
        }
        
        // 6. 이미지 리스트를 request 영역에 저장
        request.setAttribute("imageList", imageList);
        
        // 7. 이미지 목록을 보여줄 페이지로 이동
        RequestDispatcher dispatcher = request.getRequestDispatcher("/fileList.jsp");
        dispatcher.forward(request, response);
    }
    
    /**
     * 해당 파일이 이미지 파일이 맞는지 확인해주는 메소드
     */
    private boolean isImage(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".jpeg") 
              || name.endsWith(".png") || name.endsWith(".gif");
    }
    
}