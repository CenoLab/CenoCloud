
// DMSDemo.h : PROJECT_NAME Ӧ�ó������ͷ�ļ�
//

#pragma once

#ifndef __AFXWIN_H__
	#error "�ڰ������ļ�֮ǰ������stdafx.h�������� PCH �ļ�"
#endif

#include "resource.h"		// ������


// CDMSDemoApp: 
// �йش����ʵ�֣������ DMSDemo.cpp
//

class CDMSDemoApp : public CWinApp
{
public:
	CDMSDemoApp();

// ��д
public:
	virtual BOOL InitInstance();

// ʵ��

	DECLARE_MESSAGE_MAP()
};

extern CDMSDemoApp theApp;